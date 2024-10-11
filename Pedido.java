import java.util.Date;
import java.util.List;

public class Pedido {

    private int id;
    private Funcionario funcionarioSolicitante;
    private Departamento departamentoSolicitante;
    private Date dataPedido;
    private Date dataConclusao;
    private StatusPedido status;
    private List<Item> itens;
    private double valorTotal;

    // Construtor correto
    public Pedido(int id, Funcionario funcionarioSolicitante, List<Item> itens) {
        this.id = id;
        this.funcionarioSolicitante = funcionarioSolicitante;
        this.departamentoSolicitante = funcionarioSolicitante.getDepartamento(); // Obtém o departamento do funcionário
        this.dataPedido = new Date(); // Data atual
        this.itens = itens;
        this.status = StatusPedido.ABERTO; // Status inicial
        calcularValorTotal();
    }

    // Método para calcular o valor total do pedido
    private void calcularValorTotal() {
        valorTotal = itens.stream().mapToDouble(Item::getTotal).sum();
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public Funcionario getFuncionarioSolicitante() {
        return funcionarioSolicitante;
    }

    public Departamento getDepartamentoSolicitante() {
        return departamentoSolicitante;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public Date getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(Date dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public List<Item> getItens() {
        return itens;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    @Override
    public String toString() {
        return "Pedido ID: " + id + ", Funcionario: " + funcionarioSolicitante.getNome() +
                ", Departamento: " + departamentoSolicitante.getNome() + ", Valor Total: " + valorTotal +
                ", Status: " + status;
    }
}
