package kr.co.greenart;

public class Article {
	private int no;
	private String title;
	private String writer;
	private int viewcount;
	
	
	public Article() {}

	public Article(int no, String title, String writer, int viewcount) {
		super();
		this.no = no;
		this.title = title;
		this.writer = writer;
		this.viewcount = viewcount;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public int getViewcount() {
		return viewcount;
	}

	public void setViewcount(int viewcount) {
		this.viewcount = viewcount;
	}

	@Override
	public String toString() {
		return "Article [no=" + no + ", title=" + title + ", writer=" + writer + ", viewcount=" + viewcount + "]";
	}

}
