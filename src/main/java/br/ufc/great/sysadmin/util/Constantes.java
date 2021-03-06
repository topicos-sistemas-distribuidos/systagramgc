package br.ufc.great.sysadmin.util;

import java.nio.file.FileSystems;

public class Constantes {
	public static final int itensPorPagina=10;
	public static String uploadDirectory = System.getProperty("user.dir") + FileSystems.getDefault().getSeparator()+ "uploads";
	public static final String filePathQRCode = System.getProperty("user.dir") + FileSystems.getDefault().getSeparator() + "coupons";
	public static String uploadUserDirectory = System.getProperty("user.dir") + FileSystems.getDefault().getSeparator() + "users";
	public static String picturesDirectory = System.getProperty("user.dir") + FileSystems.getDefault().getSeparator() + "uploads" + FileSystems.getDefault().getSeparator() + "pictures";
	public static String bucketPrincipal = "systagram-bucket";
	public static String s3awsurl = "https://storage.cloud.google.com/systagram-bucket/";
	
}
