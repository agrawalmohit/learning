package org.sr.wm;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.sr.wm.model.Customer;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class PDFExporterUtility {

	private List<Customer> listCustomers;
	public static final String DEST = "C:\\Users\\agraw\\Documents\\test.pdf";

	public PDFExporterUtility(List<Customer> listCustomers) {
		this.listCustomers = listCustomers;
	}

	private void writeTableHeader(PdfPTable table) {
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(Color.BLUE);
		cell.setPadding(3);

		Font font = FontFactory.getFont(FontFactory.HELVETICA);
		font.setColor(Color.WHITE);

		cell.setPhrase(new Phrase("Name", font));

		table.addCell(cell);

		cell.setPhrase(new Phrase("Father Name", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Village", font));
		table.addCell(cell);

	}

	private void writeGroupedHeader(PdfPTable table) {
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(Color.BLUE);
		cell.setPadding(3);

		Font font = FontFactory.getFont(FontFactory.HELVETICA);
		font.setColor(Color.WHITE);

		cell.setPhrase(new Phrase("Name", font));

		table.addCell(cell);

		cell.setPhrase(new Phrase("Father Name", font));
		table.addCell(cell);

	}

	private void writeTableData(PdfPTable table) {
		for (Customer customer : listCustomers) {
			table.addCell(String.valueOf(customer.getName()));
			table.addCell(customer.getFatherName());
			table.addCell(customer.getVillage());
		}
	}

	private void writeGroupedData(Document document, PdfPTable table) {
		Font subBannerFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		subBannerFont.setSize(15);
		subBannerFont.setColor(Color.black);
		String prevVillage = "";
		for (Customer customer : listCustomers) {
			String curVillage = customer.getVillage();
			if (!curVillage.equalsIgnoreCase(prevVillage)) {
				Paragraph groupBanner = new Paragraph(curVillage.toUpperCase(), subBannerFont);
				groupBanner.setAlignment(Paragraph.ALIGN_LEFT);
				groupBanner.getFont().setStyle(Font.UNDERLINE);
				document.add(groupBanner);
			}
			table.addCell(String.valueOf(customer.getName()));
			table.addCell(customer.getFatherName());
			prevVillage = curVillage;
		}
	}

	public void exportGroupedDataByVillage() throws DocumentException, FileNotFoundException {
		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, new FileOutputStream(DEST));

		document.open();
		Font bannerFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		bannerFont.setSize(18);
		bannerFont.setColor(Color.BLACK);
		Font subBannerFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		subBannerFont.setSize(16);
		subBannerFont.setColor(Color.darkGray);

		Paragraph banner = new Paragraph(listCustomers.get(0).getCompanies().get(0).getBanner(), bannerFont);
		banner.setAlignment(Paragraph.ALIGN_CENTER);
		Paragraph subBanner = new Paragraph("List of Customers", subBannerFont);
		subBanner.setAlignment(Paragraph.ALIGN_CENTER);
		document.add(banner);
		document.add(subBanner);

		PdfPTable table = new PdfPTable(2);
		table.setWidthPercentage(100f);
		table.setWidths(new float[] { 3.5f, 3.5f });
		table.setSpacingBefore(10);

		writeGroupedHeader(table);
		writeGroupedData(document, table);

		document.add(table);

		document.close();
	}

	public void export() throws DocumentException, IOException {
		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, new FileOutputStream(DEST));

		document.open();
		Font bannerFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		bannerFont.setSize(18);
		bannerFont.setColor(Color.BLACK);
		Font subBannerFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		subBannerFont.setSize(16);
		subBannerFont.setColor(Color.darkGray);

		Paragraph banner = new Paragraph(listCustomers.get(0).getCompanies().get(0).getBanner(), bannerFont);
		banner.setAlignment(Paragraph.ALIGN_CENTER);
		Paragraph subBanner = new Paragraph("List of Customers", subBannerFont);
		subBanner.setAlignment(Paragraph.ALIGN_CENTER);
		document.add(banner);
		document.add(subBanner);

		PdfPTable table = new PdfPTable(3);
		table.setWidthPercentage(100f);
		table.setWidths(new float[] { 3.5f, 3.5f, 1.5f });
		table.setSpacingBefore(10);

		writeTableHeader(table);
		writeTableData(table);

		document.add(table);

		document.close();

	}
}
