package deneme;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

//import user interface
import userInterface.UserInterface;

//import converter services
import converterServiceEN.ConverterServiceEN;
import converterServiceTR.ConverterServiceTR;

public class Activator implements BundleActivator {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		System.out.println("deneme baslatiliyor...");
		
		// interface çaðýrýyorum.
		UserInterface objUserInterface = new UserInterface();
		objUserInterface.main(null);
		
		// ConverterServiceEN classýndan convertNumberToWords methoduna 5 gönderip deneyelim
		System.out.println("number to word EN = "+ ConverterServiceEN.convertNumberToWords(2925));
		System.out.println("number to word TR = "+ ConverterServiceTR.convertNumberToWords(2925));
			
		
		
		
		System.out.println("deneme baslatildi.");
	}

	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
		System.out.println("deneme durduruldu.");
	}

}
