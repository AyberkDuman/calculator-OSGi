package denemeservice;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

// import kullanilicak classlar
import converterServiceEN.ConverterServiceEN;
import converterServiceTR.ConverterServiceTR;

public class Activator implements BundleActivator {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		
		System.out.println("denemeService baslatiliyor..");
		
		// ornek olarak aþaðýdaki registryDenemeService methodu cagýrýyorum
		this.registryDenemeService();	
		
		
		System.out.println("denemeService baslatildi");
	}
	
	private void registryDenemeService(){
		ConverterServiceEN serviceEN = new ConverterServiceEN();
		context.registerService(ConverterServiceEN.class, serviceEN, null);
		
		ConverterServiceTR serviceTR = new ConverterServiceTR();
		context.registerService(ConverterServiceTR.class, serviceTR, null);
		
	}
	
	
	
	
	

	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
		System.out.println("denemeService sonlandirildi !");
	}

}
