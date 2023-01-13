public class Main {
    public static void main(String[] args) {

        ITelephone gauriPhone;
        gauriPhone = new Deskphone(12121212);
        gauriPhone.powerOn();
        gauriPhone.callPhone(12121212);
        gauriPhone.answer();
    }
}