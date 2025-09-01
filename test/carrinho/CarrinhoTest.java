package carrinho;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import produto.Produto;
import produto.ProdutoNaoEncontradoException;

@DisplayName("Classe para testes do Carrinho")
public class CarrinhoTest {
    
    private Carrinho carrinho;
    private Produto produtoA;
    private Produto produtoB;
    
    @BeforeEach
    public void setup() {
        carrinho = new Carrinho();
        produtoA = new Produto("Laptop", 2500.00);
        produtoB = new Produto("Mouse", 50.00);
    }
    
    @Test
    public void testAddItem_AdicionaUmItem() {
        carrinho.addItem(produtoA);
        assertEquals(1, carrinho.getQtdeItems());
    }

    @Test
    public void testRemoveItem_RemoveUmItem() throws ProdutoNaoEncontradoException {
        carrinho.addItem(produtoA);
        carrinho.removeItem(produtoA);
        assertEquals(0, carrinho.getQtdeItems());
    }

    @Test
    public void testGetQtdeItems_CarrinhoVazio() {
        assertEquals(0, carrinho.getQtdeItems());
    }

    @Test
    public void testGetQtdeItems_ComItens() {
        carrinho.addItem(produtoA);
        carrinho.addItem(produtoB);
        carrinho.addItem(new Produto("Teclado", 100.00));
        assertEquals(3, carrinho.getQtdeItems());
    }

    @Test
    public void testGetValorTotal_CarrinhoVazio() {
        assertEquals(0.0, carrinho.getValorTotal());
    }

    @Test
    public void testEsvazia_ComItens() {
        carrinho.addItem(produtoA);
        carrinho.addItem(produtoB);
        carrinho.esvazia();
        assertEquals(0, carrinho.getQtdeItems());
    }

    @Test
    public void testEsvazia_CarrinhoJaVazio() {
        carrinho.esvazia();
        assertEquals(0, carrinho.getQtdeItems());
    }

}