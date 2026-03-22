package com.oa.myItem.bean;

import java.util.Objects;

/**
 * ClassName: myJavaBean
 * Description:
 *
 * @Author jekny
 * @Create 2026/3/22 8:21
 * @Version 1.0
 */
public class myJavaBean {
    private int deptno;
    private String dname;
    private String loc;
    public myJavaBean() {
    }

    public myJavaBean(int deptno, String dname, String loc) {
        this.deptno = deptno;
        this.dname = dname;
        this.loc = loc;
    }

    public int getDeptno() {
        return deptno;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        myJavaBean that = (myJavaBean) o;
        return deptno == that.deptno && Objects.equals(dname, that.dname) && Objects.equals(loc, that.loc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deptno, dname, loc);
    }

    @Override
    public String toString() {
        return "myJavaBean{" +
                "deptno=" + deptno +
                ", dname='" + dname + '\'' +
                ", loc='" + loc + '\'' +
                '}';
    }
}
