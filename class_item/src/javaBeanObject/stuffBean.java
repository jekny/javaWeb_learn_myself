package javaBeanObject;

import java.util.Objects;

public class stuffBean {
    private int Wno;
    private String Wname;
    private String Wsp;
    private int Wnumb;
    private String Wposition;

    public stuffBean() {
    }

    public stuffBean(int wno, String wname, String wsp, int wnumb, String wposition) {
        Wno = wno;
        Wname = wname;
        Wsp = wsp;
        Wnumb = wnumb;
        Wposition = wposition;
    }

    public int getWno() {
        return Wno;
    }

    public void setWno(int wno) {
        Wno = wno;
    }

    public String getWname() {
        return Wname;
    }

    public void setWname(String wname) {
        Wname = wname;
    }

    public String getWsp() {
        return Wsp;
    }

    public void setWsp(String wsp) {
        Wsp = wsp;
    }

    public int getWnumb() {
        return Wnumb;
    }

    public void setWnumb(int wnumb) {
        Wnumb = wnumb;
    }

    public String getWposition() {
        return Wposition;
    }

    public void setWposition(String wposition) {
        Wposition = wposition;
    }

    @Override
    public String toString() {
        return "stuffBean{" +
                "Wno=" + Wno +
                ", Wname='" + Wname + '\'' +
                ", Wsp='" + Wsp + '\'' +
                ", Wnumb=" + Wnumb +
                ", Wposition='" + Wposition + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        stuffBean stuffBean = (stuffBean) o;
        return Wno == stuffBean.Wno && Wnumb == stuffBean.Wnumb && Objects.equals(Wname, stuffBean.Wname) && Objects.equals(Wsp, stuffBean.Wsp) && Objects.equals(Wposition, stuffBean.Wposition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Wno, Wname, Wsp, Wnumb, Wposition);
    }
}
