package lab.aikibo.validator;

import org.zkoss.bind.ValidationContext;
import org.zkoss.bind.validator.AbstractValidator;
import org.zkoss.zk.ui.util.Clients;

public class NpoptkpValidator extends AbstractValidator {

	@Override
	public void validate(ValidationContext ctx) {
		String thnPeralihan = (String) ctx.getValidatorArg("thnPeralihan");
		
		// bila panjang digit thnPeralihan lebih atau kurang dari 4, error
		if(thnPeralihan.length() != 4) {
			//this.addInvalidMessage(ctx, "Tahun peralihan harus dalam bentuk 4 digit.");
			Clients.showNotification("Tahun peralihan harus dalam bentuk 4 digit.");
		}
	}

}
