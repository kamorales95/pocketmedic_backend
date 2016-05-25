/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pocketmedic.rest.services;


import com.pocketmedic.jpa.entities.Usuario;
import com.pocketmedic.jpa.sessions.UsuarioFacade;
import com.pocketmedic.models.RecoveryPassword;
import com.pocketmedic.rest.auth.DigestUtil;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

/**
 *
 * @author Luis
 */
@Path("email")
@Stateless
public class PasswordRest {

    @EJB
    UsuarioFacade usuarioSession;

    @POST
    @Path("recoverypass")
    @Consumes(MediaType.APPLICATION_JSON)
    public void recoveryPass(RecoveryPassword recoveryPassword) {
        try {

            Usuario user = usuarioSession.findByEmail(recoveryPassword.getEmail());
            int x = (int) (Math.random() * 1000);

            String cd = null;
            try {
                cd = DigestUtil.generateDigest(String.valueOf(x));
            } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
                Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
            }

            HtmlEmail email = new HtmlEmail();

            email.setHostName("smtp.gmail.com");
            email.setSmtpPort(465);
            email.setAuthenticator(new DefaultAuthenticator("kamorales464@misena.edu.co", "1113675464"));
            email.setSSL(true);
            email.setFrom("services@pocketmedic.com");
            email.setSubject("Restablecer Contraseña Pocket Medic");
            email.setHtmlMsg("<div style=\"border-bottom:1px solid; text-align:center; background:#152836; display:inline-block; width:100%\"><img src=\"http://boticafrontend-startupcbi.rhcloud.com/images/logo.png\" alt=\"Botica\" style=\"width:5em; padding-top:1em\"><h1 style=\"margin:0; padding:0.5em 0.5em 0.5em 0; color:white; font-family:sans-serif; width:80%; display:inline-block; float:right; text-align:right\">Restablecer Contraseña</h1></div><div style=\"\">\n"
                    + "          <p style=\"padding-left:2em; margin:2em 0 2em 0; font-family:sans-serif\">Abra el siguiente enlace para continuar con el proceso de recuperación <a href=\"http://localhost:8001/#/passconfirm/" + user.getIdUsuario() + "/" + cd + "\">http://localhost:8001/#/passconfrm/" + user.getIdUsuario() + "/" + cd + "</a></p>\n"
                    + "      \n"
                    + "        </div>");
           
            email.addTo(recoveryPassword.getEmail());
            user.setCodigoRecuperacionPass(cd);
            usuarioSession.edit(user);
            email.send();
        } catch (EmailException ex) {
            Logger.getLogger(PasswordRest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}