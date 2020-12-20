package dados;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class Estacionamento {
    private Veiculo[] vaga = new Veiculo[26];
	int nrVeiculos = 0;
	
	public int getNrVeiculos() {
            return nrVeiculos;
        }
        
        public boolean entraVeiculo(String placa, String modelo, Tipo tipo, Pessoa proprietario){
        for (int a=0; a < this.vaga.length; a++){
            if (tipo.equals(Tipo.CARRO)){
            	Automovel carro = new Automovel(proprietario, placa, modelo, Tipo.CARRO);
                if (this.vaga[a] == null && this.vaga[a] == null){
                    this.vaga[a] = carro;
                    nrVeiculos++;
                    return true;
                }
            } else {
            	Motocicleta moto = new Motocicleta(proprietario, placa, modelo, Tipo.MOTO);
                if (this.vaga[a] == null){
                    this.vaga[a] = moto;
                    nrVeiculos++;
                    return true;
                } else if (this.vaga[a].getTipo().equals(Tipo.MOTO)){
                    if (this.vaga[a] == null){
                        this.vaga[a] = moto;
                        nrVeiculos++;
                        return true;
                    }
                }
            }
        }
        return false;
    }
	
	private void removeVeiculo(int g){
        this.vaga[g] = null;
        nrVeiculos--;
    }
    
    private float calculaConta(int g){
        float total = 0;
        if (this.vaga[g] != null){
            Date data = new Date();
            @SuppressWarnings("deprecation")
		int horaAtual = data.getHours();
		int tempo = horaAtual - this.vaga[g].getHora();
		if (tempo <= 1) {
                    total = (float) this.vaga[g].getCustoInicial();
                } else {
                    total = (float) (((tempo - 1) * this.vaga[g].getCustoAdicional()) + this.vaga[g].getCustoInicial());
                }
        }
        return total;
    }
    
    public float saiVeiculo(String placa){
        float conta = 0;
        for (int a=0; a < this.vaga.length; a++){
            if (this.vaga[a] != null){
                if (placa.equals(this.vaga[a].getPlaca())){
                    conta = calculaConta(a);
                    removeVeiculo(a);
                    return conta;
                }
            } 
        }
        return conta;
    }
	
    public ArrayList<Veiculo> listaEstacionados(){
    	ArrayList<Veiculo> lista = new ArrayList<>();
        Iterator it = lista.iterator();
        for (int a=0; a < this.vaga.length; a++){
            if (this.vaga[a] != null){
            
            	lista.add(this.vaga[a]);
            }
        }
        return lista;
    }
        
        
}
