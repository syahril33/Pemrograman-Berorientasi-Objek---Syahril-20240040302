public class Mahasiswa<A, B, C> {
    private A nim;
    private B name;
    private C clas;

    // Setter
    public void setNim(A nim) {
        this.nim = nim;
    }

    public void setName(B name) {
        this.name = name;
    }

    public void setClas(C clas) {
        this.clas = clas;
    }

    // Getter
    public A getNim() {
        return this.nim;
    }

    public B getName() {
        return this.name;
    }

    public C getClas() {
        return this.clas;
    }
}