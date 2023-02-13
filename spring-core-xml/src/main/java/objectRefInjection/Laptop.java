package objectRefInjection;

public class Laptop {
	Usb usb;

	public void setUsb(Usb usb) {
		this.usb = usb;
	}
	public void getLaptop() {
		System.out.println("In Laptop");
		usb.getUsb();
	}
}
