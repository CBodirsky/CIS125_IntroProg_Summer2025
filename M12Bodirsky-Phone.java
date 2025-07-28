public class M12Bodirsky_Phone {

    public static void main(String[] args) {
        // Create instances of Phone
        Phone smartPhone = new Phone();
        Phone landLine = new Phone();

        // Set properties so we can print meaningful values
        smartPhone.setPhoneNumber("555-9876");
        landLine.setModel("Panasonic KX-TGD");

        // Print requested info
        System.out.println("SmartPhone Number: " + smartPhone.getPhoneNumber());
        System.out.println("LandLine Model: " + landLine.getModel());
    }
}
