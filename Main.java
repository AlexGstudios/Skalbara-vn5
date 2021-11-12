public class Main {
    public static void main(String[] args) {
        ByteBuf byteBuf = new ByteBuf(256);

        byteBuf.writeBool(true);
        byteBuf.writeInt(256);
        byteBuf.writeSrting("Jocke");

        byteBuf.print();

        byteBuf.resetPosition();

        System.out.println(byteBuf.readBoolean());
        System.out.println(byteBuf.readInt());
        System.out.println(byteBuf.readString());
    }
}