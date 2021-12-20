package day16;

import HelperClasses.Packet;
import utils.InputReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day16 {
    private final String input;
    private int pointer = 0;
    private Packet packet;

    public Day16() {
        StringBuilder input1;
        String hex = "";

        try {
            Scanner inputReader = new Scanner(new File(new InputReader().path + "/day16.txt"));
            hex = inputReader.nextLine();
            inputReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        input1 = new StringBuilder();

        for (int i = 0; i < hex.length(); i++) {
            StringBuilder temp = new StringBuilder(Integer.toBinaryString(Integer.parseInt(hex.substring(i, i + 1), 16)));

            while (temp.length() < 4)
                temp.insert(0, "0");
            input1.append(temp);
        }
        input = input1.toString();
    }

    public long versionNumSum() {
        packet = parsePacket(input);
        return packet.versionSum();
    }

    public long hexadecimal2Long() {
        return packet.getValue();
    }

    private Packet parsePacket(String input) {
        Packet p = new Packet();

        p.setVersion(parseInt(p, input, 3));
        p.setTypeId(parseInt(p, input, 3));

        if (p.getTypeId() == 4) {
            // literal packet
            p.setValue(parseLiteral(p));
        } else {
            // operator packet
            p.setLengthTypeId(parseInt(p, input, 1));
            Packet subPacket;
            if (p.getLengthTypeId() == 0) {
                int packetsLength = 0;
                int bitLength = parseInt(p, input, 15);
                while (packetsLength < bitLength) {
                    subPacket = parsePacket(input);
                    p.addSubPacket(subPacket);
                    p.setBitLength(p.getBitLength() + subPacket.getBitLength());
                    packetsLength += subPacket.getBitLength();
                }
            } else {
                int numPackets = parseInt(p, input, 11);
                for (int i = 0; i < numPackets; i++) {
                    subPacket = parsePacket(input);
                    p.setBitLength(p.getBitLength() + subPacket.getBitLength());
                    p.addSubPacket(subPacket);
                }
            }

            // calculate the value
            if (p.getTypeId() == 0) {
                // sum packet
                for (Packet pp : p.getSubPackets()) {
                    p.setValue(p.getValue() + pp.getValue());
                }
            } else if (p.getTypeId() == 1) {
                // product packet
                if (p.getSubPackets().size() == 1)
                    p.setValue(p.getSubPackets().get(0).getValue());
                else {
                    p.setValue(1L);
                    for (Packet pp : p.getSubPackets()) {
                        p.setValue(p.getValue() * pp.getValue());
                    }
                }
            } else if (p.getTypeId() == 2) {
                // min packet
                long min = Long.MAX_VALUE;
                for (Packet pp : p.getSubPackets()) {
                    min = Math.min(min, pp.getValue());
                }
                p.setValue(min);
            } else if (p.getTypeId() == 3) {
                // max packet
                long max = Long.MIN_VALUE;
                for (Packet pp : p.getSubPackets()) {
                    max = Math.max(max, pp.getValue());
                }
                p.setValue(max);
            } else if (p.getTypeId() == 5 || p.getTypeId() == 6 || p.getTypeId() == 7) {
                boolean g = p.getSubPackets().get(0).getValue() > (p.getSubPackets().get(1).getValue());
                boolean l = p.getSubPackets().get(0).getValue() < (p.getSubPackets().get(1).getValue());
                boolean e = p.getSubPackets().get(0).getValue() == (p.getSubPackets().get(1).getValue());

                switch (p.getTypeId()) {
                    case 5:
                        p.setValue(g ? 1L : 0L);
                        break;
                    case 6:
                        p.setValue(l ? 1L : 0L);
                        break;
                    case 7:
                        p.setValue(e ? 1L : 0L);
                        break;
                }
            }

        }
        return p;
    }

    private long parseLiteral(Packet p) {
        StringBuilder literalS = new StringBuilder();
        while (true) {
            String chunk = input.substring(pointer, pointer + 5);
            pointer += 5;
            p.setBitLength(p.getBitLength() + 5);
            literalS.append(chunk.substring(1));
            if (chunk.startsWith("0"))
                break;
        }
        return Long.parseLong(literalS.toString(), 2);
    }

    private int parseInt(Packet p, String in, int l) {
        String versionS = in.substring(pointer, pointer + l);
        pointer += l;
        p.setBitLength(p.getBitLength() + l);
        return Integer.parseInt(versionS, 2);
    }
}
