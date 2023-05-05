package com.multiristorante.app.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;

@Service
@Transactional
public class EmailService {
    @Autowired
    JavaMailSender javaMailSender;
    @Value("${spring.mail.username}")
    private String email;
    private String html = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
    "<html xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\" style=\"width:100%;-webkit-text-size-adjust:100%;-ms-text-size-adjust:100%;padding:0;Margin:0\">\n" +
    " <head>\n" +
    "  <meta charset=\"UTF-8\">\n" +
    "  <meta content=\"width=device-width, initial-scale=1\" name=\"viewport\">\n" +
    "  <meta name=\"x-apple-disable-message-reformatting\">\n" +
    "  <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
    "  <meta content=\"telephone=no\" name=\"format-detection\">\n" +
    "  <title>Cozy christmas</title><!--[if (mso 16)]>\n" +
    "    <style type=\"text/css\">\n" +
    "    a {text-decoration: none;}\n" +
    "    </style>\n" +
    "    <![endif]--><!--[if gte mso 9]><style>sup { font-size: 100% !important; }</style><![endif]--><!--[if !mso]><!-- -->\n" +
    "  <link href=\"https://fonts.googleapis.com/css?family=Poppins:400,700&display=swap\" rel=\"stylesheet\">\n" +
    "  <link href=\"https://fonts.googleapis.com/css?family=Poppins:400,500,600,700,900&display=swap\" rel=\"stylesheet\"><!--<![endif]--><!--[if gte mso 9]>\n" +
    "<xml>\n" +
    "    <o:OfficeDocumentSettings>\n" +
    "    <o:AllowPNG></o:AllowPNG>\n" +
    "    <o:PixelsPerInch>96</o:PixelsPerInch>\n" +
    "    </o:OfficeDocumentSettings>\n" +
    "</xml>\n" +
    "<![endif]-->\n" +
    "  <style type=\"text/css\">\n" +
    "#outlook a {\n" +
    "\tpadding:0;\n" +
    "}\n" +
    ".ExternalClass {\n" +
    "\twidth:100%;\n" +
    "}\n" +
    ".ExternalClass,\n" +
    ".ExternalClass p,\n" +
    ".ExternalClass span,\n" +
    ".ExternalClass font,\n" +
    ".ExternalClass td,\n" +
    ".ExternalClass div {\n" +
    "\tline-height:100%;\n" +
    "}\n" +
    ".es-button {\n" +
    "\tmso-style-priority:100!important;\n" +
    "\ttext-decoration:none!important;\n" +
    "}\n" +
    "a[x-apple-data-detectors] {\n" +
    "\tcolor:inherit!important;\n" +
    "\ttext-decoration:none!important;\n" +
    "\tfont-size:inherit!important;\n" +
    "\tfont-family:inherit!important;\n" +
    "\tfont-weight:inherit!important;\n" +
    "\tline-height:inherit!important;\n" +
    "}\n" +
    ".es-desk-hidden {\n" +
    "\tdisplay:none;\n" +
    "\tfloat:left;\n" +
    "\toverflow:hidden;\n" +
    "\twidth:0;\n" +
    "\tmax-height:0;\n" +
    "\tline-height:0;\n" +
    "\tmso-hide:all;\n" +
    "}\n" +
    ".es-button-border:hover a.es-button, .es-button-border:hover button.es-button {\n" +
    "\tbackground:#065C66!important;\n" +
    "\tborder-color:#065C66!important;\n" +
    "}\n" +
    ".es-button-border:hover {\n" +
    "\tborder-color:#00f5f9 #00f5f9 #00f5f9 #00f5f9!important;\n" +
    "\tbackground:#065C66!important;\n" +
    "}\n" +
    "[data-ogsb] .es-button {\n" +
    "\tborder-width:0!important;\n" +
    "\tpadding:10px 20px 10px 20px!important;\n" +
    "}\n" +
    "@media only screen and (max-width:600px) {p, ul li, ol li, a { line-height:150%!important } h1, h2, h3, h1 a, h2 a, h3 a { line-height:120%!important } h1 { font-size:28px!important; text-align:center } h2 { font-size:24px!important; text-align:center } h3 { font-size:18px!important; text-align:center } .es-header-body h1 a, .es-content-body h1 a, .es-footer-body h1 a { font-size:28px!important } .es-header-body h2 a, .es-content-body h2 a, .es-footer-body h2 a { font-size:24px!important } .es-header-body h3 a, .es-content-body h3 a, .es-footer-body h3 a { font-size:18px!important } .es-menu td a { font-size:12px!important } .es-header-body p, .es-header-body ul li, .es-header-body ol li, .es-header-body a { font-size:12px!important } .es-content-body p, .es-content-body ul li, .es-content-body ol li, .es-content-body a { font-size:13px!important } .es-footer-body p, .es-footer-body ul li, .es-footer-body ol li, .es-footer-body a { font-size:10px!important } .es-infoblock p, .es-infoblock ul li, .es-infoblock ol li, .es-infoblock a { font-size:11px!important } *[class=\"gmail-fix\"] { display:none!important } .es-m-txt-c, .es-m-txt-c h1, .es-m-txt-c h2, .es-m-txt-c h3 { text-align:center!important } .es-m-txt-r, .es-m-txt-r h1, .es-m-txt-r h2, .es-m-txt-r h3 { text-align:right!important } .es-m-txt-l, .es-m-txt-l h1, .es-m-txt-l h2, .es-m-txt-l h3 { text-align:left!important } .es-m-txt-r img, .es-m-txt-c img, .es-m-txt-l img { display:inline!important } .es-button-border { display:inline-block!important } a.es-button, button.es-button { font-size:16px!important; display:inline-block!important } .es-btn-fw { border-width:10px 0px!important; text-align:center!important } .es-adaptive table, .es-btn-fw, .es-btn-fw-brdr, .es-left, .es-right { width:100%!important } .es-content table, .es-header table, .es-footer table, .es-content, .es-footer, .es-header { width:100%!important; max-width:600px!important } .es-adapt-td { display:block!important; width:100%!important } .adapt-img { width:100%!important; height:auto!important } .es-m-p0 { padding:0px!important } .es-m-p0r { padding-right:0px!important } .es-m-p0l { padding-left:0px!important } .es-m-p0t { padding-top:0px!important } .es-m-p0b { padding-bottom:0!important } .es-m-p20b { padding-bottom:20px!important } .es-mobile-hidden, .es-hidden { display:none!important } tr.es-desk-hidden, td.es-desk-hidden, table.es-desk-hidden { width:auto!important; overflow:visible!important; float:none!important; max-height:inherit!important; line-height:inherit!important } tr.es-desk-hidden { display:table-row!important } table.es-desk-hidden { display:table!important } td.es-desk-menu-hidden { display:table-cell!important } table.es-table-not-adapt, .esd-block-html table { width:auto!important } table.es-social { display:inline-block!important } table.es-social td { display:inline-block!important } .es-desk-hidden { display:table-row!important; width:auto!important; overflow:visible!important; max-height:inherit!important } }\n" +
    "</style>\n" +
    " </head>\n" +
    " <body style=\"width:100%;-webkit-text-size-adjust:100%;-ms-text-size-adjust:100%;font-family:tahoma, verdana, segoe, sans-serif;padding:0;Margin:0\">\n" +
    "  <div class=\"es-wrapper-color\" style=\"background-color:#F6F6F6\"><!--[if gte mso 9]>\n" +
    "\t\t\t<v:background xmlns:v=\"urn:schemas-microsoft-com:vml\" fill=\"t\">\n" +
    "\t\t\t\t<v:fill type=\"tile\" color=\"#f6f6f6\"></v:fill>\n" +
    "\t\t\t</v:background>\n" +
    "\t\t<![endif]-->\n" +
    "   <table class=\"es-wrapper\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;padding:0;Margin:0;width:100%;height:100%;background-repeat:repeat;background-position:center top;background-color:#F6F6F6\">\n" +
    "     <tr style=\"border-collapse:collapse\">\n" +
    "      <td valign=\"top\" style=\"padding:0;Margin:0\">\n" +
    "       <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-content\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%\">\n" +
    "         <tr style=\"border-collapse:collapse\">\n" +
    "          <td align=\"center\" bgcolor=\"#07095e\" style=\"padding:0;Margin:0;background-color:#07095e\">\n" +
    "           <table bgcolor=\"transparent\" class=\"es-content-body\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:transparent;width:600px\">\n" +
    "             <tr style=\"border-collapse:collapse\">\n" +
    "              <td align=\"left\" style=\"Margin:0;padding-left:10px;padding-right:10px;padding-bottom:15px;padding-top:20px\"><!--[if mso]><table style=\"width:580px\"><tr><td style=\"width:280px\" valign=\"top\"><![endif]-->\n" +
    "               <table class=\"es-left\" cellspacing=\"0\" cellpadding=\"0\" align=\"left\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;float:left\">\n" +
    "                 <tr style=\"border-collapse:collapse\">\n" +
    "                  <td align=\"left\" style=\"padding:0;Margin:0;width:280px\">\n" +
    "                   <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
    "                     <tr style=\"border-collapse:collapse\">\n" +
    "                      <td class=\"es-infoblock es-m-txt-c\" align=\"left\" style=\"padding:0;Margin:0;line-height:14px;font-size:12px;color:#CCCCCC\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:tahoma, verdana, segoe, sans-serif;line-height:14px;color:#CCCCCC;font-size:12px\"><br></p></td>\n" +
    "                     </tr>\n" +
    "                   </table></td>\n" +
    "                 </tr>\n" +
    "               </table><!--[if mso]></td><td style=\"width:20px\"></td><td style=\"width:280px\" valign=\"top\"><![endif]-->\n" +
    "               <table class=\"es-right\" cellspacing=\"0\" cellpadding=\"0\" align=\"right\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;float:right\">\n" +
    "                 <tr style=\"border-collapse:collapse\">\n" +
    "                  <td align=\"left\" style=\"padding:0;Margin:0;width:280px\">\n" +
    "                   <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
    "                     <tr style=\"border-collapse:collapse\">\n" +
    "                      <td align=\"right\" class=\"es-infoblock es-m-txt-c\" style=\"padding:0;Margin:0;line-height:14px;font-size:12px;color:#CCCCCC\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:tahoma, verdana, segoe, sans-serif;line-height:14px;color:#CCCCCC;font-size:12px\"><br></p></td>\n" +
    "                     </tr>\n" +
    "                   </table></td>\n" +
    "                 </tr>\n" +
    "               </table><!--[if mso]></td></tr></table><![endif]--></td>\n" +
    "             </tr>\n" +
    "           </table></td>\n" +
    "         </tr>\n" +
    "       </table>\n" +
    "       <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-content\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%\">\n" +
    "         <tr style=\"border-collapse:collapse\">\n" +
    "          <td align=\"center\" bgcolor=\"#eeeded\" style=\"padding:0;Margin:0;background-color:#eeeded\">\n" +
    "           <table bgcolor=\"transparent\" class=\"es-content-body\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:transparent;width:600px\">\n" +
    "             <tr style=\"border-collapse:collapse\">\n" +
    "              <td align=\"left\" bgcolor=\"#000000\" style=\"padding:0;Margin:0;padding-top:20px;padding-left:20px;padding-right:20px;background-color:#000000\">\n" +
    "               <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
    "                 <tr style=\"border-collapse:collapse\">\n" +
    "                  <td align=\"left\" style=\"padding:0;Margin:0;width:560px\">\n" +
    "                   <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
    "                     <tr style=\"border-collapse:collapse\">\n" +
    "                      <td align=\"center\" style=\"padding:0;Margin:0;font-size:0px\"><a target=\"_blank\" href=\"https://viewstripo.email\" style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;text-decoration:underline;color:#2CB543;font-size:15px\"><img src=\"https://elasticbeanstalk-us-east-1-332396321235.s3.amazonaws.com/images/logo.jpeg\" alt style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic\" width=\"339\"></a></td>\n" +
    "                     </tr>\n" +
    "                   </table></td>\n" +
    "                 </tr>\n" +
    "               </table></td>\n" +
    "             </tr>\n" +
    "             <tr style=\"border-collapse:collapse\">\n" +
    "              <td align=\"left\" style=\"padding:0;Margin:0\">\n" +
    "               <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
    "                 <tr style=\"border-collapse:collapse\">\n" +
    "                  <td align=\"center\" valign=\"top\" style=\"padding:0;Margin:0;width:600px\">\n" +
    "                   <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
    "                     <tr style=\"border-collapse:collapse\">\n" +
    "                      <td align=\"center\" style=\"padding:0;Margin:0;font-size:0px\"><img class=\"adapt-img\" src=\"https://media.admagazine.com/photos/618a5d11532cae908aaf27ab/master/w_1600%2Cc_limit/96644.jpg\" alt style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic\" width=\"600\"></td>\n" +
    "                     </tr>\n" +
    "                   </table></td>\n" +
    "                 </tr>\n" +
    "               </table></td>\n" +
    "             </tr>\n" +
    "             <tr style=\"border-collapse:collapse\">\n" +
    "              <td align=\"left\" bgcolor=\"#ffffff\" style=\"Margin:0;padding-top:20px;padding-left:20px;padding-right:20px;padding-bottom:30px;background-color:#ffffff\">\n" +
    "               <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
    "                 <tr style=\"border-collapse:collapse\">\n" +
    "                  <td align=\"left\" class=\"es-m-p20b\" style=\"padding:0;Margin:0;width:560px\">\n" +
    "                   <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
    "                     <tr style=\"border-collapse:collapse\">\n" +
    "                      <td align=\"center\" style=\"padding:0;Margin:0;padding-bottom:5px\"><h1 style=\"Margin:0;line-height:59px;mso-line-height-rule:exactly;font-family:Poppins, sans-serif;font-size:49px;font-style:normal;font-weight:bold;color:#00413f\">REGISTRO EXITOSO</h1></td>\n" +
    "                     </tr>\n" +
    "                     <tr style=\"border-collapse:collapse\">\n" +
    "                      <td align=\"center\" style=\"padding:0;Margin:0;padding-bottom:5px\"><h2 style=\"Margin:0;line-height:34px;mso-line-height-rule:exactly;font-family:Poppins, sans-serif;font-size:28px;font-style:normal;font-weight:bold;color:#00413f\">¡Gracias por registrarte!</h2></td>\n" +
    "                     </tr>\n" +
    "                     <tr style=\"border-collapse:collapse\">\n" +
    "                      <td align=\"center\" style=\"Margin:0;padding-left:5px;padding-right:5px;padding-top:10px;padding-bottom:10px\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:tahoma, verdana, segoe, sans-serif;line-height:23px;color:#333333;font-size:15px\">¡Bienvenido a la familia de MultiRestorante!.&nbsp;<br>Ahora puedes disfrutar de muchos beneficios, ingresa con tus credenciales y empieza a navegar por nuestro gran catálogo de restaurantes.</p></td>\n" +
    "                     </tr>\n" +
    "                   </table></td>\n" +
    "                 </tr>\n" +
    "               </table></td>\n" +
    "             </tr>\n" +
    "           </table></td>\n" +
    "         </tr>\n" +
    "       </table>\n" +
    "       <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-footer\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%;background-color:transparent;background-repeat:repeat;background-position:center top\">\n" +
    "         <tr style=\"border-collapse:collapse\">\n" +
    "          <td align=\"center\" bgcolor=\"#07095e\" style=\"padding:0;Margin:0;background-color:#07095e\">\n" +
    "           <table bgcolor=\"#ffffff\" class=\"es-footer-body\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:#C1272C;width:600px\">\n" +
    "             <tr style=\"border-collapse:collapse\">\n" +
    "              <td align=\"left\" bgcolor=\"#020202\" style=\"Margin:0;padding-top:10px;padding-bottom:10px;padding-left:20px;padding-right:20px;background-color:#020202\"><!--[if mso]><table style=\"width:560px\" cellpadding=\"0\" cellspacing=\"0\"><tr><td style=\"width:270px\" valign=\"top\"><![endif]-->\n" +
    "               <table class=\"es-left\" cellspacing=\"0\" cellpadding=\"0\" align=\"left\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;float:left\">\n" +
    "                 <tr style=\"border-collapse:collapse\">\n" +
    "                  <td valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;width:270px\">\n" +
    "                   <table style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-position:center top\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" role=\"presentation\">\n" +
    "                     <tr style=\"border-collapse:collapse\">\n" +
    "                      <td class=\"es-m-txt-c\" align=\"left\" style=\"padding:0;Margin:0;padding-bottom:10px;padding-top:15px\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:tahoma, verdana, segoe, sans-serif;line-height:18px;color:#FFFFFF;font-size:12px\">MultiRestorante</p></td>\n" +
    "                     </tr>\n" +
    "                   </table></td>\n" +
    "                 </tr>\n" +
    "               </table><!--[if mso]></td><td style=\"width:20px\"></td><td style=\"width:270px\" valign=\"top\"><![endif]-->\n" +
    "               <table class=\"es-right\" cellspacing=\"0\" cellpadding=\"0\" align=\"right\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;float:right\">\n" +
    "                 <tr style=\"border-collapse:collapse\">\n" +
    "                  <td align=\"left\" style=\"padding:0;Margin:0;width:270px\">\n" +
    "                   <table style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-position:center top\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" role=\"presentation\">\n" +
    "                     <tr style=\"border-collapse:collapse\">\n" +
    "                      <td class=\"es-m-txt-c\" align=\"right\" style=\"padding:0;Margin:0;padding-top:5px;padding-bottom:5px;font-size:0\">\n" +
    "                       <table class=\"es-table-not-adapt es-social\" cellspacing=\"0\" cellpadding=\"0\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
    "                         <tr style=\"border-collapse:collapse\">\n" +
    "                          <td valign=\"top\" align=\"center\" style=\"padding:0;Margin:0\"><a target=\"_blank\" href=\"https://www.instagram.com/bodyhealthcucuta/?hl=es\" style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;text-decoration:underline;color:#FFFFFF;font-size:14px\"><img title=\"Instagram\" src=\"https://akhpyb.stripocdn.email/content/assets/img/social-icons/logo-white/instagram-logo-white.png\" alt=\"Inst\" width=\"32\" style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic\"></a></td>\n" +
    "                         </tr>\n" +
    "                       </table></td>\n" +
    "                     </tr>\n" +
    "                   </table></td>\n" +
    "                 </tr>\n" +
    "               </table><!--[if mso]></td></tr></table><![endif]--></td>\n" +
    "             </tr>\n" +
    "           </table></td>\n" +
    "         </tr>\n" +
    "       </table>\n" +
    "       <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-content\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%\">\n" +
    "         <tr style=\"border-collapse:collapse\">\n" +
    "          <td align=\"center\" bgcolor=\"#07095e\" style=\"padding:0;Margin:0;background-color:#07095e\">\n" +
    "           <table bgcolor=\"transparent\" class=\"es-content-body\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:transparent;width:600px\">\n" +
    "             <tr style=\"border-collapse:collapse\">\n" +
    "              <td align=\"left\" style=\"Margin:0;padding-left:20px;padding-right:20px;padding-top:30px;padding-bottom:30px\">\n" +
    "               <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
    "                 <tr style=\"border-collapse:collapse\">\n" +
    "                  <td valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;width:560px\">\n" +
    "                   <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
    "                     <tr style=\"border-collapse:collapse\">\n" +
    "                      <td align=\"left\" style=\"padding:0;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:tahoma, verdana, segoe, sans-serif;line-height:23px;color:#333333;font-size:15px\"></p></td>\n" +
    "                     </tr>\n" +
    "                   </table></td>\n" +
    "                 </tr>\n" +
    "               </table></td>\n" +
    "             </tr>\n" +
    "           </table></td>\n" +
    "         </tr>\n" +
    "       </table></td>\n" +
    "     </tr>\n" +
    "   </table>\n" +
    "  </div>\n" +
    " </body>\n" + "</html>";

    public void sendListEmail(String emailTo) {
        MimeMessage message = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(email);
            helper.setTo(emailTo);
            helper.setSubject("Registro exitoso a multirestoranti");
            helper.setText(html,true);
            javaMailSender.send(message);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
