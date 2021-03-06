/**
 * @author Sandra Paulina Argote Romo
 */

package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Grupo {
    private String idGrupo, idMateria, idCarrera,nombreMateria,carrera,maestro,periodo,
    turno, grupo,numAlumnos,semestre,creditos,aula,lunes, martes, miercoles, jueves, viernes;

    public String getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(String idGrupo) {
        this.idGrupo = idGrupo;
    }

    public String getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(String idMateria) {
        this.idMateria = idMateria;
    }

    public String getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(String idCarrera) {
        this.idCarrera = idCarrera;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getMaestro() {
        return maestro;
    }

    public void setMaestro(String maestro) {
        this.maestro = maestro;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getNumAlumnos() {
        return numAlumnos;
    }

    public void setNumAlumnos(String numAlumnos) {
        this.numAlumnos = numAlumnos;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public String getCreditos() {
        return creditos;
    }

    public void setCreditos(String creditos) {
        this.creditos = creditos;
    }

    public String getAula() {
        return aula;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }

    public String getLunes() {
        return lunes;
    }

    public void setLunes(String lunes) {
        this.lunes = lunes;
    }

    public String getMartes() {
        return martes;
    }

    public void setMartes(String martes) {
        this.martes = martes;
    }

    public String getMiercoles() {
        return miercoles;
    }

    public void setMiercoles(String miercoles) {
        this.miercoles = miercoles;
    }

    public String getJueves() {
        return jueves;
    }

    public void setJueves(String jueves) {
        this.jueves = jueves;
    }

    public String getViernes() {
        return viernes;
    }

    public void setViernes(String viernes) {
        this.viernes = viernes;
    }
    
    //Sabana    
    public static ArrayList<Grupo> getSabana(String idCarrera) {
        ArrayList<Grupo> grupos = new ArrayList<Grupo>();
        try {
            Connection con = JavaDB.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT G.IDGRUPO, G.IDMATERIA,C.IDCARRERA, M.NOMBREMATERIA,C.NOMBRECARRERA, MA.NOMBREMAESTRO,G.PERIODO,G.TURNO, G.GRUPO, G.NUMALUMNOS, M.SEMESTRE,M.CREDITOS, G.AULA, G.LUNES,G.MARTES,G.MIERCOLES, G.JUEVES,G.VIERNES FROM GRUPO G, MAESTRO MA, CARRERA C, MATERIA M WHERE MA.IDMAESTRO = G.IDMAESTRO AND G.IDMATERIA = M.IDMATERIA AND G .IDCARRERA = C.IDCARRERA AND G.IDCARRERA='"+idCarrera+"'");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Grupo s = new Grupo();

                s.setIdGrupo(rs.getString(1));
                s.setIdMateria(rs.getString(2));
                s.setIdCarrera(rs.getString(3));
                s.setNombreMateria(rs.getString(4));
                s.setCarrera(rs.getString(5));
                s.setMaestro(rs.getString(6));
                s.setPeriodo(rs.getString(7));
                s.setTurno(rs.getString(8));
                s.setGrupo(rs.getString(9));
                s.setNumAlumnos(rs.getString(10));
                s.setSemestre(rs.getString(11));
                s.setCreditos(rs.getString(12));
                s.setAula(rs.getString(13));
                s.setLunes(rs.getString(14));
                s.setMartes(rs.getString(15));
                s.setMiercoles(rs.getString(16));
                s.setJueves(rs.getString(17));
                s.setViernes(rs.getString(18));

                grupos.add(s);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return grupos;
    }
}