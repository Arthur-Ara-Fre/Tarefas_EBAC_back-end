package br.com.afreitas;

/**
 * @author arthur.freitas
 */
public class Cliente {
    String gradeRequest;
    Boolean hasCompanyContract;

    public Cliente(String gradeRequest, Boolean hasCompanyContract){
        this.gradeRequest = gradeRequest;
        this.hasCompanyContract = hasCompanyContract;
    }

    public Boolean getHasCompanyContract() {
        return hasCompanyContract;
    }

    public String getGradeRequest() {
        return gradeRequest;
    }
}
