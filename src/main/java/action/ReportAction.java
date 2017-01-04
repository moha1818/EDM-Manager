package action;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import entity.Accountdetail;
import entity.ProductCount;
import entity.User;
import service.impl.AccountdetailServiceImpl;
import service.impl.ProductCountServiceImpl;
import service.impl.UserServiceImpl;

@Controller(value = "reportAction")
@Scope(scopeName = "prototype")
public class ReportAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	@Autowired
	@Qualifier(value = "userServiceImpl")
	private UserServiceImpl userServiceImpl;

	@Autowired
	@Qualifier(value = "accountdetailServiceImpl")
	private AccountdetailServiceImpl accountdetailServiceImpl;

	@Autowired
	@Qualifier(value = "productCountServiceImpl")
	private ProductCountServiceImpl productCountServiceImpl;

	private String reportType;
	private List<User> users;
	private List<Accountdetail> detail;
	private List<ProductCount> product;
	private Date starttime;
	private Date endtime;
	private int x;
	private int y;

	// 显示报表管理页面
	public String showReport() {

		return SUCCESS;
	}

	public String getReport() {

		if (reportType.equals("balance")) {
			users = userServiceImpl.balance();

			return "balance";
		}
		if (reportType.equals("preRunning")) {
			detail = accountdetailServiceImpl.preRunning(starttime, endtime);

			return "preRunning";
		}
		if (reportType.equals("agentRunning")) {
			detail = accountdetailServiceImpl.agentRunning(starttime, endtime);

			return "agentRunning";
		}
		if (reportType.equals("categories")) {
			product = productCountServiceImpl.getCount();

			return "categories";
		}
		return INPUT;
	}

	private InputStream excelStream; // 输出流变量
	private String excelFileName; // 下载文件名

	public String exportExcel() {
		try {
		// 第一步，创建一个webbook，对应一个Excel文件
		HSSFWorkbook wb = new HSSFWorkbook();
		// 第二步，在webbook中添加一个sheet，对应Excel文件中的 sheet
		HSSFSheet sheet = wb.createSheet("测试表格1");
		// 第三步，在sheet中添加表头第0行，注意老版本poi对Excel的行数列数有限制
		HSSFRow row = sheet.createRow(0);
		// 第四步，创建单元格样式：居中
		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		// 第五步，创建表头单元格，并设置样式
		HSSFCell cell;

		if (reportType.equals("balance")) {

			cell = row.createCell(0);
			cell.setCellValue("序号");
			cell.setCellStyle(style);

			cell = row.createCell(1);
			cell.setCellValue("代理商名称");
			cell.setCellStyle(style);

			cell = row.createCell(2);
			cell.setCellValue("账户余额");
			cell.setCellStyle(style);

			users = userServiceImpl.balance();
			if (users.size() >= 1) {
				for (int i = 1; i <= users.size(); i++) {
					row = sheet.createRow(i);
					User user = users.get(i - 1);
					row.createCell(0).setCellValue(i);
					row.createCell(1).setCellValue(user.getUserName());
					row.createCell(2).setCellValue(user.getAccount().getMoney());
				}
			}
			
			excelFileName = "reportBalance.xls"; // 设置下载的文件名

		}
		if (reportType.equals("preRunning")) {
			cell = row.createCell(0);
			cell.setCellValue("序号");
			cell.setCellStyle(style);

			cell = row.createCell(1);
			cell.setCellValue("代理商名称");
			cell.setCellStyle(style);
			
			cell = row.createCell(2);
			cell.setCellValue("预付款");
			cell.setCellStyle(style);
			
			cell = row.createCell(3);
			cell.setCellValue("账户余额");
			cell.setCellStyle(style);
			
			cell = row.createCell(4);
			cell.setCellValue("备注信息");
			cell.setCellStyle(style);
			
			cell = row.createCell(5);
			cell.setCellValue("时间");
			cell.setCellStyle(style);
			
			SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd : hh-mm-ss");
			
			detail = accountdetailServiceImpl.preRunning(starttime, endtime);
			if(detail.size()>=1){
				for (int i = 1; i <= detail.size(); i++) {
					row = sheet.createRow(i);
					Accountdetail accountdetail = detail.get(i - 1);
					row.createCell(0).setCellValue(i);
					row.createCell(1).setCellValue(accountdetail.getUser().getUserName());
					row.createCell(2).setCellValue(accountdetail.getMoney());
					row.createCell(3).setCellValue(accountdetail.getAccountMoney());
					row.createCell(4).setCellValue(accountdetail.getMemo());
					row.createCell(5).setCellValue(fmt.format(accountdetail.getDetailDateTime()));
				}
			}
			excelFileName = "reportPreRunning.xls"; // 设置下载的文件名

		}
		if (reportType.equals("agentRunning")) {
			cell = row.createCell(0);
			cell.setCellValue("序号");
			cell.setCellStyle(style);

			cell = row.createCell(1);
			cell.setCellValue("代理商名称");
			cell.setCellStyle(style);
			
			cell = row.createCell(2);
			cell.setCellValue("预付款");
			cell.setCellStyle(style);
			
			cell = row.createCell(3);
			cell.setCellValue("账户余额");
			cell.setCellStyle(style);
			
			cell = row.createCell(4);
			cell.setCellValue("备注信息");
			cell.setCellStyle(style);
			
			cell = row.createCell(5);
			cell.setCellValue("时间");
			cell.setCellStyle(style);
			
			SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd : hh-mm-ss");
			detail = accountdetailServiceImpl.agentRunning(starttime, endtime);
			if(detail.size()>=1){
				for (int i = 1; i <= detail.size(); i++) {
					row = sheet.createRow(i);
					Accountdetail accountdetail = detail.get(i - 1);
					row.createCell(0).setCellValue(i);
					row.createCell(1).setCellValue(accountdetail.getUser().getUserName());
					row.createCell(2).setCellValue(accountdetail.getMoney());
					row.createCell(3).setCellValue(accountdetail.getAccountMoney());
					row.createCell(4).setCellValue(accountdetail.getMemo());
					row.createCell(5).setCellValue(fmt.format(accountdetail.getDetailDateTime()));
				}
			}
			excelFileName = "reportAgentRunning.xls"; // 设置下载的文件名

		}
		if (reportType.equals("categories")) {
			cell = row.createCell(0);
			cell.setCellValue("序号");
			cell.setCellStyle(style);

			cell = row.createCell(1);
			cell.setCellValue("产品分类名称");
			cell.setCellStyle(style);
			
			cell = row.createCell(2);
			cell.setCellValue("数量");
			cell.setCellStyle(style);
			
			cell = row.createCell(3);
			cell.setCellValue("价格");
			cell.setCellStyle(style);
			
			product = productCountServiceImpl.getCount();
			if(product.size()>=1){
				for (int i = 1; i <= product.size(); i++) {
					row = sheet.createRow(i);
					ProductCount productCount = product.get(i - 1);
					row.createCell(0).setCellValue(i);
					row.createCell(1).setCellValue(productCount.getTypeName());
					row.createCell(2).setCellValue(productCount.getCount());
					row.createCell(3).setCellValue(productCount.getMoney());
				}
			}
			excelFileName = "reportCategories.xls"; // 设置下载的文件名
		}
		
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		
			wb.write(os);
		
		byte[] fileContent = os.toByteArray();
		ByteArrayInputStream is = new ByteArrayInputStream(fileContent);

		excelStream = is; // 文件流
		return SUCCESS;
		} catch (IOException e) {
			e.printStackTrace();
			return INPUT;
		}
	}

	public InputStream getExcelStream() {
		return excelStream;
	}

	public void setExcelStream(InputStream excelStream) {
		this.excelStream = excelStream;
	}

	public String getExcelFileName() {
		return excelFileName;
	}

	public void setExcelFileName(String excelFileName) {
		this.excelFileName = excelFileName;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public List<ProductCount> getProduct() {
		return product;
	}

	public void setProduct(List<ProductCount> product) {
		this.product = product;
	}

	public List<Accountdetail> getDetail() {
		return detail;
	}

	public void setDetail(List<Accountdetail> detail) {
		this.detail = detail;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public String getReportType() {
		return reportType;
	}

	public void setReportType(String reportType) {
		this.reportType = reportType;
	}

	public Date getStarttime() {
		return starttime;
	}

	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}

	public Date getEndtime() {
		return endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}

}
