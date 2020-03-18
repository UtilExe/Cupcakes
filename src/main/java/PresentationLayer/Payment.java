package PresentationLayer;

import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Payment extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        //TODO Træk samlet pris fra kundens saldo. Tilføj ordre til orderline og orders. Giv bekræftigelse/kvittering. Opret midlertidig bruger for saldo

        return null;
    }
}
