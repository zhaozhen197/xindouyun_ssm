package com.hello.util;

import javax.net.ssl.X509TrustManager;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**信任管理器
 * Created by zane on 2016/10/27.
 */
public class MyX509TrustManager implements X509TrustManager{

//	检查客户端证书
	public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

	}
//检查服务器端的证书
	public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

	}
//返回受信任的x509证书
	public X509Certificate[] getAcceptedIssuers() {
		return new X509Certificate[0];
	}
}
