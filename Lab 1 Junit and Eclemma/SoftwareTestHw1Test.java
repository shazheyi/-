package com.junit4.main;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class SoftwareTestHw1Test {
	private SoftwareTestHw1 testHw1;
	private int in;
	private String res;

	public SoftwareTestHw1Test(int in,String res) {
		this.in=in;
		this.res=res;
	}
	
	@Parameters
	public static Collection getData() {
		return Arrays.asList(new Object[][] {
			{-10,"No"},//��Χ������ֵ
			{-1,"No"},//�����߽�ֵ��ֵ
			{0,"Yes"},//����һ���߽�ֵ
			{1,"Yes"},//��Χ�ڳɹ�ֵ
			{79,"No"},//��Χ�ڲ��ɹ�ֵ
			{93,"Yes"},//������һ���߽�ֵ
			{94,"No"},//�����߽�ֵ��ֵ
			{100,"No"}//��Χ������ֵ
		});
	}
	@Before
	public void setUp() throws Exception {
		testHw1=new SoftwareTestHw1();
	}

	@AfterClass
	public static void tearDown() throws Exception {
		System.out.println();
	}

	@Test
	public void testOutput() {	
		assertEquals(this.res, testHw1.outPut(this.in)); 
	}

}
