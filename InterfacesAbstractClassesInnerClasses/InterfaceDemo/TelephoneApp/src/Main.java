public class Main {
    public static void main(String[] args) {

        ITelephone gauriPhone;
        gauriPhone = new Deskphone(12121212);
        gauriPhone.powerOn();
        gauriPhone.callPhone(12121212);
        gauriPhone.answer();


        gauriPhone = new Mobilephone(99887766);
        // Mobile phone is off and we are trying to call -- will give error message
        gauriPhone.callPhone(99887766);

        // turned on mobile phone & then call and answer
        gauriPhone.powerOn();
        gauriPhone.callPhone(99887766);
        gauriPhone.answer();
    }
}