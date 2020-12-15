package entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonBackReference;

@Entity
@Table(name = "CONTATO")
public class Contato {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "S_CONTATO")
	@SequenceGenerator(name = "S_CONTATO", sequenceName = "S_CONTATO", initialValue = 1, allocationSize = 1)
	@Column(name = "ID", nullable = false)
	private int id;
	@Column(name = "EMAIL", nullable = false)
	private String email;
	@Column(name = "TELEFONE", nullable = false)
	private String telefone;
	@OneToOne
	@JoinColumn(name = "CLIENTE", referencedColumnName = "CPF", nullable = false)
	@JsonBackReference // Utilizado para evitar redundancia ciclica
	private Cliente cliente;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


}
