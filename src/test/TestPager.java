package test;

import org.junit.Test;

import com.icss.hr.common.Pager;

public class TestPager {
	
	@Test
	public void test() {
		
		Pager pager = new Pager(25, 1);
		
		System.out.println("��" + pager.getRecordCount() + "������,ÿҳ"
				+ pager.getPageSize() + "������" + pager.getPageCount()
				+ "ҳ����ǰ�ǵ�" + pager.getPageNum() + "ҳ���ӵ�"
				+ pager.getStart() + "������" + pager.getEnd() + "��");
		
	}

}
