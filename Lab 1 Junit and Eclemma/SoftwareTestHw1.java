package com.junit4.main;

public class SoftwareTestHw1 {
	/*
	�ú���˼��Ϊ������8�����ң�1��50,1��20��1��10,2��5,3��1������ôÿ������Ƿ�
	ȡ�ÿ�����8λ����������ʾ��0������,1����ʹ�ã��������Ļ������Ա���0-255��
	������תΪ��Ӧ�Ļ��ҽ��
	*/
	public int F(int x) {
		if(x==0) return 0;
		int[] n= {1,1,1,5,5,10,20,50};
		int out=0;
		int cnt=0;
		while(x!=0) {
			out+=n[cnt++]*(x%2);
			x/=2;
		}
		return out;
	}
	//����������������п��ܵĻ��ҽ��鿴�������Ƿ��п���
	public String outPut(int in) {
		boolean judge=false;
		String out="";
		if(in<=93&&in>=0) { //��С����ֵΪ0��������ֵΪ93����Χ֮���ֱ�Ӳ�����
			for(int i=0;i<256;i++) {
			  if(in==F(i)) {
				 judge=true;
				 break;
			  }
		    }
		}
		if(judge) {
			out="Yes";
		}else {
			out="No";
		}
		return out;
	}
//	public static void main(String[] args) {
//		SoftwareTestHw1 testHw1=new SoftwareTestHw1(93);
//		testHw1.outPut();
//	}

}
