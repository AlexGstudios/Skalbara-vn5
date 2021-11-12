public class ByteBuf {

    private byte[] byteArr;
    private int position = 0;

    public ByteBuf() {
        this.byteArr = new byte[64];
    }

    public ByteBuf(int i) {
        this.byteArr = new byte[i];
    }

    public void writeBool(boolean bool) {
        byteArr[position++] = (byte) (bool ? 1 : 0);
    }

    public void writeInt(int integer) {
        byteArr[position++] = (byte) (integer >>> 24 & 0xFF);
        byteArr[position++] = (byte) (integer >>> 16 & 0xFF);
        byteArr[position++] = (byte) (integer >>> 8 & 0xFF);
        byteArr[position++] = (byte) (integer >>> 0 & 0xFF);
    }

    public void writeSrting(String str) {
        writeInt(str.length());

        for (int i = 0; i < str.length(); i++) {
            byteArr[position++] = (byte) str.charAt(i);
        }
    }

    public boolean readBoolean() {
        return byteArr[position++] == 1;
    }

    public int readInt() {
        return (byteArr[position++] << 24) + (byteArr[position++] << 16) + (byteArr[position++] << 8)
                + (byteArr[position++]);
    }

    public String readString() {
        int in = readInt();
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < in; i++) {

            char ch = (char) byteArr[position++];
            str.append(ch);
        }

        return str.toString();
    }

    public void resetPosition() {
        this.position = 0;
    }

    public void print() {
        for (int i = 0; i < byteArr.length; i++) {
            System.out.print(byteArr[i] + ", ");
        }
        System.out.println();
    }
}