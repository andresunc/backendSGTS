package Backend.SGTS.Entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "contacto_empresa", schema = "sgts_db", catalog = "")
public class ContactoEmpresaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_Contacto_Empresa", nullable = false)
    private Integer idContactoEmpresa;
    @Basic
    @Column(name = "Nombre", nullable = true, length = 45)
    private String nombre;
    @Basic
    @Column(name = "Apellido", nullable = true, length = 45)
    private String apellido;
    @Basic
    @Column(name = "Telefono", nullable = true, length = 45)
    private String telefono;
    @Basic
    @Column(name = "Email", nullable = true, length = 100)
    private String email;
    @Basic
    @Column(name = "Empresa_id_Empresa", nullable = false)
    private int empresaIdEmpresa;
    
    public ContactoEmpresaEntity() {}

    public Integer getIdContactoEmpresa() {
        return idContactoEmpresa;
    }

    public void setIdContactoEmpresa(Integer idContactoEmpresa) {
        this.idContactoEmpresa = idContactoEmpresa;
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

    public int getEmpresaIdEmpresa() {
        return empresaIdEmpresa;
    }

    public void setEmpresaIdEmpresa(int empresaIdEmpresa) {
        this.empresaIdEmpresa = empresaIdEmpresa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactoEmpresaEntity that = (ContactoEmpresaEntity) o;
        return idContactoEmpresa == that.idContactoEmpresa && empresaIdEmpresa == that.empresaIdEmpresa && Objects.equals(nombre, that.nombre) && Objects.equals(apellido, that.apellido) && Objects.equals(telefono, that.telefono) && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idContactoEmpresa, nombre, apellido, telefono, email, empresaIdEmpresa);
    }
}
