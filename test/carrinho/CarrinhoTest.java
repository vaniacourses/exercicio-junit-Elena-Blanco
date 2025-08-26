package carrinho;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import produto.Produto;
import produto.ProdutoNaoEncontradoException;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Classe para teste do Carrinho")
public class CarrinhoTest {

    private Carrinho carrinho;

    @BeforeEach
    public void inicializa() {
        carrinho = new Carrinho();
    }

   @Test
    @DisplayName("Testa se getValorTotal retorna 0 para carrinho vazio")
    public void testGetValorTotalCarrinhoVazio() {
        assertEquals(0.0, carrinho.getValorTotal());
    }

    @Test
    @DisplayName("Testa se addItem adiciona produto e reflete no valor total")
    public void testAddItem() {
        Produto p1 = new Produto("Blush", 10.0);

        carrinho.addItem(p1);

        assertEquals(10.0, carrinho.getValorTotal());
        assertEquals(1, carrinho.getQtdeItems());
    }

    @Test
    @DisplayName("Testa se addItem com múltiplos produtos soma valores corretamente")
    public void testAddMultiplosItens() {
        Produto p1 = new Produto("Blush", 10.0);
        Produto p2 = new Produto("Batom", 8.5);

        carrinho.addItem(p1);
        carrinho.addItem(p2);

        assertEquals(18.5, carrinho.getValorTotal());
        assertEquals(2, carrinho.getQtdeItems());
    }

    @Test
    @DisplayName("Testa se removeItem remove item existente e atualiza valor total")
    public void testRemoveItemExistente() throws ProdutoNaoEncontradoException {
        Produto p1 = new Produto("Blush", 10.0);
        Produto p2 = new Produto("Batom", 8.0);

        carrinho.addItem(p1);
        carrinho.addItem(p2);

        carrinho.removeItem(p1);

        assertEquals(8.0, carrinho.getValorTotal());
        assertEquals(1, carrinho.getQtdeItems());
    }

    @Test
    @DisplayName("Testa se removeItem lança exceção ao remover produto inexistente")
    public void testRemoveItemInexistente() {
        Produto p1 = new Produto("Blush", 10.0);
        Produto p2 = new Produto("Batom", 8.0);

        carrinho.addItem(p1);

        assertThrows(ProdutoNaoEncontradoException.class, 
            () -> carrinho.removeItem(p2));
    }

        @Test
    @DisplayName("Testa se getQtdeItems retorna a quantidade correta de itens")
    public void testGetQtdeItems() {
        Produto p1 = new Produto("Blush", 10.0);
        Produto p2 = new Produto("Batom", 8.0);

        carrinho.addItem(p1);
        carrinho.addItem(p2);

        assertEquals(2, carrinho.getQtdeItems());
    }

    @Test
    @DisplayName("Testa se esvazia remove todos os itens e zera o valor total")
    public void testEsvazia() {
        Produto p1 = new Produto("Blush", 10.0);
        Produto p2 = new Produto("Batom", 8.0);

        carrinho.addItem(p1);
        carrinho.addItem(p2);

        assertEquals(2, carrinho.getQtdeItems());
        assertEquals(18.0, carrinho.getValorTotal());

        carrinho.esvazia();

        assertEquals(0, carrinho.getQtdeItems());
        assertEquals(0.0, carrinho.getValorTotal());
    }
}
