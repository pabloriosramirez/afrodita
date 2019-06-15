package online.grisk.afrodita.estrategy.impl;

import online.grisk.afrodita.dto.ResponseRestAPI;
import online.grisk.afrodita.entity.Email;
import online.grisk.afrodita.entity.Organization;
import online.grisk.afrodita.entity.Role;
import online.grisk.afrodita.entity.User;
import online.grisk.afrodita.estrategy.Estrategy;
import online.grisk.afrodita.model.OrganizationModel;
import online.grisk.afrodita.model.UserModel;
import online.grisk.afrodita.service.OrganizationService;
import online.grisk.afrodita.service.RoleService;
import online.grisk.afrodita.service.UserService;
import online.grisk.afrodita.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.UUID;

@Component
public class CreatedUserAdminByLogin implements Estrategy {

    @Autowired
    UUID uuid;

    @Autowired
    UserService userService;

    @Autowired
    OrganizationService organizationService;

    @Autowired
    RoleService roleService;

    @Autowired
    String token;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public ResponseEntity<ResponseRestAPI> execute(Object object) {
        try {
            UserModel presentedUser = (UserModel) object;
            if (userService.findByUsername(presentedUser.getUsername()) == null
                    && userService.findByEmail(presentedUser.getEmail()) == null) {
                Role role = roleService.findByCode("ADMIN");
                if (role == null)
                    return new ResponseEntity<ResponseRestAPI>(new ResponseRestAPI(uuid,
                            HttpStatus.INTERNAL_SERVER_ERROR, "Ha ocurrido un problema inesperado", new Date(), null),
                            HttpStatus.INTERNAL_SERVER_ERROR);
                String tokenConfirm = token;
                String textSignUp = "Hola, necesitamos validar tu correo electrónico para poder activar tu cuenta.  Simplemente copia esta url en tu navegador: http://www.grisk.online/login/confirm/TOKEN_AUTH".replaceAll("TOKEN_AUTH", tokenConfirm);
                String htmlSignUp = "<html><head> <title>Activación de cuenta GRisk</title> <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"> <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"> <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\"> <style type=\"text/css\"> #outlook a{padding: 0;}.ReadMsgBody{width: 100%;}.ExternalClass{width: 100%;}.ExternalClass *{line-height: 100%;}body{margin: 0; padding: 0; -webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%;}table, td{border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt;}img{border: 0; height: auto; line-height: 100%; outline: none; text-decoration: none; -ms-interpolation-mode: bicubic;}p{display: block; margin: 13px 0;}</style> <style type=\"text/css\"> @media only screen and (max-width: 480px){@-ms-viewport{width: 320px;}@viewport{width: 320px;}}</style><!--[if mso]> <xml> <o:OfficeDocumentSettings> <o:AllowPNG/> <o:PixelsPerInch>96</o:PixelsPerInch> </o:OfficeDocumentSettings> </xml><![endif]--><!--[if lte mso 11]> <style type=\"text/css\"> .outlook-group-fix{width: 100% !important;}</style><![endif]--> <link href=\"https://fonts.googleapis.com/css?family=\" rel=\"stylesheet\" type=\"text/css\"> <link href=\"https://fonts.googleapis.com/css?family=Consolas\" rel=\"stylesheet\" type=\"text/css\"> <style type=\"text/css\"> @import url(https://fonts.googleapis.com/css?family=); @import url(https://fonts.googleapis.com/css?family=Consolas); </style> <style type=\"text/css\"> @media only screen and (min-width: 480px){.mj-column-per-100{width: 100% !important; max-width: 100%;}}</style> <style type=\"text/css\"> [owa] .mj-column-per-100{width: 100% !important; max-width: 100%;}</style> <style type=\"text/css\"> @media only screen and (max-width: 480px){table.full-width-mobile{width: 100% !important;}td.full-width-mobile{width: auto !important;}}</style></head><body style=\"background-color:#F4F4F4;\"><div style=\"background-color:#F4F4F4;\"><!--[if mso | IE]> <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"\" style=\"width:600px;\" width=\"600\" > <tr> <td style=\"line-height:0px;font-size:0px;mso-line-height-rule:exactly;\"><![endif]--> <div style=\"Margin:0px auto;max-width:600px;\"> <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"width:100%;\"> <tbody> <tr> <td style=\"direction:ltr;font-size:0px;padding:20px 0;padding-bottom:0px;padding-top:0px;text-align:center;vertical-align:top;\"><!--[if mso | IE]> <table role=\"presentation\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"> <tr> <td class=\"\" style=\"vertical-align:top;width:600px;\" ><![endif]--> <div class=\"mj-column-per-100 outlook-group-fix\" style=\"font-size:13px;text-align:left;direction:ltr;display:inline-block;vertical-align:top;width:100%;\"> <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"vertical-align:top;\" width=\"100%\"> <tbody> <tr> <td align=\"center\" style=\"background:#ffffff;font-size:0px;padding:0px 0px 0px 0px;padding-top:0px;padding-right:0px;padding-bottom:0px;padding-left:0px;word-break:break-word;\"> <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"border-collapse:collapse;border-spacing:0px;margin-top: 50px;\"> <tbody> <tr> <td style=\"width:94px;\"> <a href=\"http://www.grisk.online\" target=\"_blank\"> <img alt=\"GRISK\" height=\"auto\" src=\"http://www.grisk.online/images/grisk.png\" style=\"border:none;border-radius:px;display:block;outline:none;text-decoration:none;height:auto;width:100%;\" title=\"\" width=\"94\"> </a> </td></tr></tbody> </table> </td></tr></tbody> </table> </div><!--[if mso | IE]> </td></tr></table><![endif]--> </td></tr></tbody> </table> </div><!--[if mso | IE]> </td></tr></table> <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"\" style=\"width:600px;\" width=\"600\" > <tr> <td style=\"line-height:0px;font-size:0px;mso-line-height-rule:exactly;\"><![endif]--> <div style=\"background:#ffffff;background-color:#ffffff;Margin:0px auto;max-width:600px;\"> <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"background:#ffffff;background-color:#ffffff;width:100%;\"> <tbody> <tr> <td style=\"border:0px solid #ffffff;direction:ltr;font-size:0px;padding:20px 0px 20px 0px;padding-bottom:20px;padding-left:0px;padding-right:0px;padding-top:20px;text-align:center;vertical-align:top;\"><!--[if mso | IE]> <table role=\"presentation\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"> <tr> <td class=\"\" style=\"vertical-align:top;width:600px;\" ><![endif]--> <div class=\"mj-column-per-100 outlook-group-fix\" style=\"font-size:13px;text-align:left;direction:ltr;display:inline-block;vertical-align:top;width:100%;\"> <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"vertical-align:top;\" width=\"100%\"> <tbody> <tr> <td align=\"left\" style=\"font-size:0px;padding:0px 25px 0px 25px;padding-top:0px;padding-bottom:0px;word-break:break-word;\"> <div style=\"font-family:Arial, sans-serif;font-size:13px;line-height:22px;text-align:left;color:#55575d;\"> <h1 style=\"font-size: 20px; font-weight: bold; text-align: center;\">Activa tu cuenta</h1> </div></td></tr><tr> <td align=\"left\" style=\"font-size:0px;padding:0px 25px 0px 25px;padding-top:0px;padding-bottom:0px;word-break:break-word;\"> <div style=\"font-family:Arial, sans-serif;font-size:13px;line-height:22px;text-align:left;color:#55575d;\"> <p style=\"font-size: 13px; text-align: center; margin: 10px 0;\">Necesitamos validar tu correo electrónico para poder activar tu cuenta <b style=\"font-weight:700\">GRisk.</b> Simplemente haz click en el siguiente botón:</p></div></td></tr><tr> <td align=\"center\" vertical-align=\"middle\" style=\"font-size:0px;padding:10px 25px 10px 25px;padding-top:10px;padding-right:25px;padding-bottom:10px;padding-left:25px;word-break:break-word;\"> <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"border-collapse:separate;line-height:100%;\"> <tbody> <tr> <td align=\"center\" bgcolor=\"#7c0acd\" role=\"presentation\" style=\"border:0px solid #ffffff;border-radius:3px;cursor:auto;padding:10px 25px 10px 25px;background:#7c0acd;\" valign=\"middle\"> <a href=\"http://www.grisk.online/login/confirm/TOKEN_AUTH\" style=\"background:#7c0acd;color:#ffffff;font-family:Arial, sans-serif;font-size:13px;font-weight:normal;line-height:120%;Margin:0;text-decoration:none;text-transform:none;\" target=\"_blank\"> Confirmar mi cuenta </a> </td></tr></tbody> </table> </td></tr></tbody> </table> </div><!--[if mso | IE]> </td></tr></table><![endif]--> </td></tr></tbody> </table> </div><!--[if mso | IE]> </td></tr></table> <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"\" style=\"width:600px;\" width=\"600\" > <tr> <td style=\"line-height:0px;font-size:0px;mso-line-height-rule:exactly;\"><![endif]--> <div style=\"background:#ffffff;background-color:#ffffff;Margin:0px auto;max-width:600px;\"> <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"background:#ffffff;background-color:#ffffff;width:100%;\"> <tbody> <tr> <td style=\"direction:ltr;font-size:0px;padding:20px 0;text-align:center;vertical-align:top;\"><!--[if mso | IE]> <table role=\"presentation\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"> <tr> <td class=\"\" style=\"vertical-align:top;width:600px;\" ><![endif]--> <div class=\"mj-column-per-100 outlook-group-fix\" style=\"font-size:13px;text-align:left;direction:ltr;display:inline-block;vertical-align:top;width:100%;\"> <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"vertical-align:top;\" width=\"100%\"> <tbody> <tr> <td align=\"left\" style=\"font-size:0px;padding:10px 25px;padding-top:0px;padding-bottom:0px;word-break:break-word;\"> <div style=\"font-family:Arial, sans-serif;font-size:13px;line-height:22px;text-align:left;color:#55575d;\"> <p style=\"font-size: 13px; margin: 10px 0; text-align: center;\">Si el botón no funciona, copia esta url en tu navegador:</p><p style=\"font-size: 13px; margin: 10px 0; text-align: center;\"> <a href=\"http://www.grisk.online/login/confirm/TOKEN_AUTH\">http://www.grisk.online/login/confirm/TOKEN_AUTH</a></p></div></td></tr></tbody> </table> </div><!--[if mso | IE]> </td></tr></table><![endif]--> </td></tr></tbody> </table> </div><!--[if mso | IE]> </td></tr></table> <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"\" style=\"width:600px;\" width=\"600\" > <tr> <td style=\"line-height:0px;font-size:0px;mso-line-height-rule:exactly;\"><![endif]--> <div style=\"Margin:0px auto;max-width:600px;\"> <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"width:100%;\"> <tbody> <tr> <td style=\"direction:ltr;font-size:0px;padding:0px 0px 0px 0px;text-align:center;vertical-align:top;\"><!--[if mso | IE]> <table role=\"presentation\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"> <tr> <td class=\"\" style=\"vertical-align:top;width:600px;\" ><![endif]--> <div class=\"mj-column-per-100 outlook-group-fix\" style=\"font-size:10px;text-align:left;direction:ltr;display:inline-block;vertical-align:top;width:100%;\"> <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" width=\"100%\"> <tbody> <tr> <td style=\"vertical-align:top;padding:0;\"> <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"\" width=\"100%\"> <tbody> <tr> <td align=\"center\" style=\"font-size:0px;padding:10px 25px;padding-top:0px;padding-bottom:0px;word-break:break-word;\"> <div style=\"font-family:Arial, sans-serif;font-size:11px;line-height:22px;text-align:center;color:#55575d;\"> <p style=\"font-size: 10px; margin: 10px 0;\">Se envió este correo electrónico porque se registró en una cuenta de <b style=\"font-weight:700;\">GRisk</b>, háganos saber si cree que este correo electrónico le fue enviado por error, enviando un correo a <b style=\"font-weight:700;\"><span style=\"text-decoration: none; font-weight: 700;\">hola@grisk.online</span></b> </p><p style=\"font-size: 10px; margin: 0px 0;\"><span style=\"color:#222222; font-family:Consolas,\" lucida=\"\" console\",\"courier=\"\" new\",monospace;=\"\" font-size:12px\"=\"\">© 2019 GRisk | <a href=\"http://www.grisk.online\">www.grisk.online</a> </span> </p></div></td></tr></tbody> </table> </td></tr></tbody> </table> </div><!--[if mso | IE]> </td></tr></table><![endif]--> </td></tr></tbody> </table> </div><!--[if mso | IE]> </td></tr></table> <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"\" style=\"width:600px;\" width=\"600\" > <tr> <td style=\"line-height:0px;font-size:0px;mso-line-height-rule:exactly;\"><![endif]--><!--[if mso | IE]> </td></tr></table><![endif]--></div></body></html>".replaceAll("TOKEN_AUTH", tokenConfirm);
                Email email = new Email(presentedUser.getEmail(), "Activación de cuenta de GRisk", textSignUp, htmlSignUp);

                ResponseRestAPI responseEmailAPI = restTemplate.postForObject("http://hermes/v1/rest/mail/send", email, ResponseRestAPI.class);

                if (responseEmailAPI.getStatus() == HttpStatus.OK) {
                    OrganizationModel presentedOrganization = presentedUser.getOrganization();
                    Organization existedOrganization = organizationService.findByRut(presentedOrganization.getRut());
                    if (existedOrganization == null) {
                        existedOrganization = organizationService
                                .save(new Organization(presentedOrganization.getRut(), presentedOrganization.getName()));
                    }
                    User user = userService
                            .save(new User(presentedUser.getUsername(), presentedUser.getEmail(), Constant.encryte(presentedUser.getPass()), null, tokenConfirm,
                                    false, true, (short) 0, new Date(), new Date(), existedOrganization, role));

                    return new ResponseEntity<ResponseRestAPI>(new ResponseRestAPI(uuid, HttpStatus.OK,
                            "Se ha enviado correctamente el correo para restablecer contraseña de cuenta.", new Date(), null), HttpStatus.OK);

                }
                return new ResponseEntity<ResponseRestAPI>(new ResponseRestAPI(uuid,
                        HttpStatus.INTERNAL_SERVER_ERROR, "Ha ocurrido un problema inesperado", new Date(), null),
                        HttpStatus.INTERNAL_SERVER_ERROR);

            } else {
                return new ResponseEntity<ResponseRestAPI>(new ResponseRestAPI(uuid,
                        HttpStatus.CONFLICT, "Usuario ya registrado con el mismo username y/o email.", new Date(), null),
                        HttpStatus.CONFLICT);
            }
        } catch (Exception e) {
            return new ResponseEntity<ResponseRestAPI>(new ResponseRestAPI(uuid,
                    HttpStatus.INTERNAL_SERVER_ERROR, "Ha ocurrido un problema inesperado", new Date(), null),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
