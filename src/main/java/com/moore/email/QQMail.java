package com.moore.email;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.*;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

/**
 * Java发送邮件
 *
 * @author moore
 * @date 2019-12-26
 */
public class QQMail {
    public static void main(String[] args) throws AddressException, MessagingException, UnsupportedEncodingException {
        Properties properties = new Properties();
        properties.put("mail.transport.protocol", "smtp");// 连接协议
        properties.put("mail.smtp.host", "smtp.qq.com");// 主机名
        properties.put("mail.smtp.port", 465);// 端口号
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.ssl.enable", "true");// 设置是否使用ssl安全连接 ---一般都使用
        properties.put("mail.debug", "true");// 设置是否显示debug信息 true 会在控制台显示相关信息
        // 得到回话对象
        Session session = Session.getInstance(properties);
        // 获取邮件对象
        Message message = new MimeMessage(session);
        // 设置发件人邮箱地址
        message.setFrom(new InternetAddress("793665514@qq.com"));
        // 设置收件人邮箱地址
        message.setRecipients(Message.RecipientType.TO, new InternetAddress[]{
                // 设置多个收件人new多个InternetAddress对象
                new InternetAddress("793665514@qq.com")});
        //message.setRecipient(Message.RecipientType.TO, new InternetAddress("xxx@qq.com"));//一个收件人
        // 设置邮件标题
        message.setSubject("你的小可爱给你发了一个邮件");
        // 设置邮件内容可以使用Html标签
        MimeBodyPart image = new MimeBodyPart();
        DataHandler dh = new DataHandler(new FileDataSource("C:\\Users\\Moore\\Pictures\\c8ba12758afe80b5b63945e8720a2888.jpg"));
        image.setDataHandler(dh);
        // 图片ID
        image.setContentID("image_id");

        // 文字节点
        MimeBodyPart text = new MimeBodyPart();
        text.setContent("Hello, 你收得到我的邮件嘛<br/><img src='cid:image_id'/>", "text/html;charset=UTF-8");

        // 将文本和图片节点结合
        MimeMultipart text_image = new MimeMultipart();
        text_image.addBodyPart(text);
        text_image.addBodyPart(image);
        //关联关系 有内嵌资源要定义related
        text_image.setSubType("related");
        MimeBodyPart text_image_body = new MimeBodyPart();
        text_image_body.setContent(text_image);

        // 附件节点
        MimeBodyPart document = new MimeBodyPart();
        //读取本地文档
        DataHandler dhdoc = new DataHandler(new FileDataSource("d:\\Users\\Moore\\Desktop\\BigData.docx"));
        //将附件数据添加到节点
        document.setDataHandler(dhdoc);
        //设置附件文件名
        document.setFileName(MimeUtility.decodeText(dhdoc.getName()));

        MimeMultipart mm = new MimeMultipart();
        mm.addBodyPart(text_image_body);
        mm.addBodyPart(document);
        //有附件资源要定义mixed
        mm.setSubType("mixed");

        // 组装message对象
        message.setContent(mm);
        message.setSentDate(new Date());
        message.saveChanges();

        // 得到邮差对象
        Transport transport = session.getTransport();
        // 连接自己的邮箱账户
        transport.connect("793665514@qq.com", "rycryaiacdprbdbc");// 密码为QQ邮箱开通的stmp服务后得到的客户端授权码
        // 发送邮件
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
    }
}
