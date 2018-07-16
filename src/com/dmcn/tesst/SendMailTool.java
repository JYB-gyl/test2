package com.dmcn.tesst;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMailTool {

	private static String smtp_host = "smtp.163.com"; // ����
	private static String username = "17603214676@163.com"; // �����˻�
	private static String password = "bdqn597701"; // ������Ȩ��

	private static String from = "17603214676@163.com"; // ʹ�õ�ǰ�˻�

	/**
	 * 
	 * @Title:<p>sendMail</p>
	 * @Description ���ʼ��ķ���
	 * @param subject ����
	 * @param content ����
	 * @param to    �ռ�������
	 * @return <p>void</p>
	 * @author <p>��־��</p>
	 * @date <p>2018��6��26�� ����3:08:20</p>
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
			System.err.println("�ʼ��ѷ���");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("�ʼ�����ʧ��...");
		}
	}
	
	public static void main(String[] args) {
		sendMail("�����������","<a href='https://www.baidu.com'>����,����,����</a>","1649206977@qq.com");
	}
}
