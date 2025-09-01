import carrinho.Carrinho;
import produto.Produto;
import produto.ProdutoNaoEncontradoException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarrinhoTest {

    private Carrinho carrinho;
    private Produto produto1;
    private Produto produto2;

    @BeforeEach
    void setUp() {
        // Inicializa um novo carrinho e produtos antes de cada teste
        carrinho = new Carrinho();
        produto1 = new Produto("Monitor LED 24\"", 799.90);
        produto2 = new Produto("Mouse sem fio", 120.50);
    }

    @Test
    @DisplayName("Deve iniciar com 0 itens e valor total 0.0")
    void testCarrinhoVazio() {
        assertEquals(0, carrinho.getQtdeItems(), "Carrinho novo deve ter 0 itens.");
        assertEquals(0.0, carrinho.getValorTotal(), "Carrinho novo deve ter valor total 0.0.");
    }

    @Test
    @DisplayName("Deve adicionar um item corretamente")
    void testAddItem() {
        carrinho.addItem(produto1);
        assertEquals(1, carrinho.getQtdeItems(), "Deve ter 1 item após adicionar.");
        assertEquals(799.90, carrinho.getValorTotal(), "O valor total deve ser o preço do item adicionado.");
    }

    @Test
    @DisplayName("Deve adicionar múltiplos itens e calcular o total")
    void testAddMultiplosItems() {
        carrinho.addItem(produto1);
        carrinho.addItem(produto2);
        assertEquals(2, carrinho.getQtdeItems(), "Deve ter 2 itens após adicionar.");
        assertEquals(920.40, carrinho.getValorTotal(), 0.001, "O valor total deve ser a soma dos preços.");
    }

    @Test
    @DisplayName("Deve remover um item existente")
    void testRemoveItemExistente() throws ProdutoNaoEncontradoException {
        carrinho.addItem(produto1);
        carrinho.addItem(produto2);

        carrinho.removeItem(produto1);

        assertEquals(1, carrinho.getQtdeItems(), "A quantidade de itens deve ser 1 após remover.");
        assertEquals(120.50, carrinho.getValorTotal(), "O valor total deve ser o do item restante.");
    }
    
    @Test
    @DisplayName("Deve remover item com base no nome (devido ao método equals)")
    void testRemoveItemPorNome() throws ProdutoNaoEncontradoException {
        carrinho.addItem(produto1); // Monitor LED 24"
        
        // Cria um novo objeto Produto com o mesmo nome mas preço diferente
        Produto produtoParaRemover = new Produto("Monitor LED 24\"", 999.99); 
        
        // Deve remover produto1 porque o 'equals' compara apenas o nome
        carrinho.removeItem(produtoParaRemover); 
        
        assertEquals(0, carrinho.getQtdeItems(), "Carrinho deveria estar vazio após remoção por nome.");
    }

    @Test
    @DisplayName("Deve lançar exceção ao tentar remover item inexistente")
    void testRemoveItemInexistente() {
        Produto produtoInexistente = new Produto("Teclado Mecânico", 350.00);
        carrinho.addItem(produto1);

        // Verifica se a exceção correta é lançada
        assertThrows(ProdutoNaoEncontradoException.class, () -> {
            carrinho.removeItem(produtoInexistente);
        }, "Deve lançar ProdutoNaoEncontradoException para item inexistente.");
    }

    @Test
    @DisplayName("Deve esvaziar o carrinho completamente")
    void testEsvazia() {
        carrinho.addItem(produto1);
        carrinho.addItem(produto2);

        carrinho.esvazia();

        assertEquals(0, carrinho.getQtdeItems(), "A quantidade de itens deve ser 0 após esvaziar.");
        assertEquals(0.0, carrinho.getValorTotal(), "O valor total deve ser 0.0 após esvaziar.");
    }
}