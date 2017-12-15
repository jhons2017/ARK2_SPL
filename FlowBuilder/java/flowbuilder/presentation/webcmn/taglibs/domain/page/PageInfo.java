package flowbuilder.presentation.webcmn.taglibs.domain.page;


import java.io.Serializable;

public class PageInfo implements Serializable {

    private int recordCountNumber = 0; // 全部の記録��

    private int pageCountNumber = 0; // 全部の頁��

    private int recordPerPage = 0; // 毎頁の記録��

    private int currentPage = 0; // ���O目前頁��

    private int previousPageNumber = 0; // 前頁���O��

    private int nextPageNumber = 0; // 下頁
    
    private String methods = "";// 方法��

    public PageInfo() {
    }
    
    public int getRecordCountNumber() {
        return this.recordCountNumber;
    }

    public int getPageCountNumber() {
        if (recordCountNumber == 0)
            return 0;
        if (recordPerPage == 0)
            return 1;
        if (this.recordCountNumber % this.recordPerPage == 0) {
            this.pageCountNumber = this.recordCountNumber / this.recordPerPage;
        } else {
            this.pageCountNumber = (this.recordCountNumber / this.recordPerPage) + 1;
        }
        return this.pageCountNumber;
    }

    public int getRecordPerPage() {
        return this.recordPerPage;
    }
    public void setRecordPerPage(int recordPerPage){
        this.recordPerPage=recordPerPage;
    }

    public int getCurrentPage() {
        return this.currentPage;
    }

    public int getLastPageNumber() {
        return this.pageCountNumber;
    }

    public int getPreviousPageNumber() {
        this.previousPageNumber = this.currentPage - 1;
        return this.previousPageNumber;
    }

    public int getNextPageNumber() {
        this.nextPageNumber = this.currentPage + 1;
        return this.nextPageNumber;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public void setRecordCountNumber(int recordCountNumber) {
        this.recordCountNumber = recordCountNumber;
    }
    
    public void setMethod(String name) {
        this.methods = name;
    }

    public String getMethod() {
        return this.methods;
    }
    
}