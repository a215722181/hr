package test;

import org.junit.Test;

import com.icss.hr.common.Pager;

public class TestPager {
	
	@Test
	public void test() {
		
		Pager pager = new Pager(25, 1);
		
		System.out.println("共" + pager.getRecordCount() + "条数据,每页"
				+ pager.getPageSize() + "条，共" + pager.getPageCount()
				+ "页，当前是第" + pager.getPageNum() + "页，从第"
				+ pager.getStart() + "条到第" + pager.getEnd() + "条");
		
	}

}
