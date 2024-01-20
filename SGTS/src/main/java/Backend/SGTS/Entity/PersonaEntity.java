package Backend.SGTS.Entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "persona", schema = "sgts_db", catalog = "")
public class PersonaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_Persona", nullable = false)
    private Integer idPersona;
    @Basic
    @Column(name = "Nombre", nullable = false, length = 45)
    private String nombre;
    @Basic
    @Column(name = "Apellido", nullable = false, length = 45)
    private String apellido;
    @Basic
    @Column(name = "Dni", nullable = false, length = 10)
    private String dni;
    @Basic
    @Column(name = "Telefono", nullable = true, length = 45)
    private String telefono;
    @Basic
    @Column(name = "Email", nullable = true, length = 100)
    private String email;

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonaEntity that = (PersonaEntity) o;
        return idPersona == that.idPersona && Objects.equals(nombre, that.nombre) && Objects.equals(apellido, that.apellido) && Objects.equals(dni, that.dni) && Objects.equals(telefono, that.telefono) && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPersona, nombre, apellido, dni, telefono, email);
    }
}
