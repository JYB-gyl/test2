package com.dmcn.tesst;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMailTool {

	private static String smtp_host = "smtp.163.com"; // 网易
	private static String username = "17603214676@163.com"; // 邮箱账户
	private static String password = "bdqn597701"; // 邮箱授权码

	private static String from = "17603214676@163.com"; // 使用当前账户

	/**
	 * 
	 * @Title:<p>sendMail</p>
	 * @Description 发邮件的方法
	 * @param subject 标题
	 * @param content 内容
	 * @param to    收件人邮箱
	 * @return <p>void</p>
	 * @author <p>韩志彬</p>
	 * @date <p>2018年6月26日 下午3:08:20</p>
	 *
	 */
	public static void sendMail(String subject, String content, String to) {
		Properties props = new Properties();
		props.setProperty("mail.smtp.host", smtp_host);
		props.setProperty("mail.transport.protocol", "smtp");
		props.setProperty("mail.smtp.auth", "true");
		Session session = Session.getInstance(props);
		Message message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(from));
			message.setRecipient(RecipientType.TO, new InternetAddress(to));
			message.setSubject(subject);
			message.setContent(content, "text/html;charset=utf-8");
			Transport transport = session.getTransport();
			transport.connect(smtp_host, username, password);
			transport.sendMessage(message, message.getAllRecipients());
			System.err.println("邮件已发送");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("邮件发送失败...");
		}
	}
	
	public static void main(String[] args) {
		sendMail("北大青鸟测试","<a href='https://www.baidu.com'>点我,点我,点我</a>","1649206977@qq.com");
	}
}
