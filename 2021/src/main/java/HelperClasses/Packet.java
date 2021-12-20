package HelperClasses;

import java.util.LinkedList;
import java.util.List;

public class Packet {
    public long value;
    public int typeId;
    public int version;
    public int lengthTypeId;
    public int bitLength;
    public List<Packet> subPackets;

    public Packet(long value, int typeId, int version, int lengthTypeId, int bitLength, List<Packet> subPackets) {
        this.value = value;
        this.typeId = typeId;
        this.version = version;
        this.lengthTypeId = lengthTypeId;
        this.bitLength = bitLength;
        this.subPackets = subPackets;
    }

    public Packet() {
        value = 0L;
        typeId = 0;
        version = 0;
        lengthTypeId = 0;
        bitLength = 0;
        subPackets = new LinkedList<>();
    }

    public long versionSum() {
        long sum = version;

        for (Packet subPacket : subPackets) {
            sum += subPacket.versionSum();
        }
        return sum;
    }

    public String toString() {
        return version + " " + typeId + " " + " " + value;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getLengthTypeId() {
        return lengthTypeId;
    }

    public void setLengthTypeId(int lengthTypeId) {
        this.lengthTypeId = lengthTypeId;
    }

    public int getBitLength() {
        return bitLength;
    }

    public void incrementBitLength(int len) {
        bitLength += len;
    }

    public void setBitLength(int bitLength) {
        this.bitLength = bitLength;
    }

    public List<Packet> getSubPackets() {
        return subPackets;
    }

    public void setSubPackets(List<Packet> subPackets) {
        this.subPackets = subPackets;
    }

    public void addSubPacket(Packet subPacket) {
        this.subPackets.add(subPacket);
    }
}
