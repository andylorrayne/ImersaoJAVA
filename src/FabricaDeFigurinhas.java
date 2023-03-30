import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import javax.imageio.ImageIO;


public class FabricaDeFigurinhas {
    public void cria(InputStream inputStream, String nomeArquivo, String comentario, InputStream icones) throws Exception {
        //leitura da imagem

       // BufferedImage imagemOriginal = ImageIO.read(new File("consumindoAPI/entrada/filme.jpg"));
        BufferedImage imagemOriginal = ImageIO.read(inputStream);


        //criar imagem em memoria com transparencia e tamanho diferente

        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();

        int novaAltura = altura + 200;
        BufferedImage novImagem =  new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);


        //copiar a imagem original para nova imagem (em memória)

        Graphics2D graphics =  (Graphics2D) novImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0 , 0,  null);

        //configurar fonte
        var fonteSize = largura/100 * 5;

        var fonte = new Font("Impact", Font.CENTER_BASELINE , fonteSize);
        graphics.setColor(Color.YELLOW);
        graphics.setFont(fonte);

        // ICONE 
        BufferedImage iconeAndy = ImageIO.read(icones);
        int iconeY = altura;//altura - iconeAndy.getHeight();
        graphics.drawImage(iconeAndy, 0, iconeY, 200, 200, null);


        //variaveis de calculo para localização da frase
        int textoLegenda = comentario.length();
        int posicaoTextoX = largura/3-textoLegenda;
        int posicaoTextoY = novaAltura - 100;

        //posição do texto
        
        graphics.drawString(comentario, posicaoTextoX, posicaoTextoY);

        //contornando o texto
        FontRenderContext fontRenderContext = graphics.getFontRenderContext();
        var textLayout = new TextLayout(comentario, fonte, fontRenderContext);

        Shape outline = textLayout.getOutline(null);
        AffineTransform transform = graphics.getTransform();
        transform.translate(posicaoTextoX, posicaoTextoY);
        graphics.setTransform(transform);


        var outlineStroke =  new BasicStroke(largura * 0.004f);
        graphics.setStroke(outlineStroke);
        graphics.setColor(Color.BLACK);
        graphics.draw(outline);
        graphics.setClip(outline);


        

        //escrever imagem nova em arquivo

        File saida = new File("./saida/"); 

        if(saida.exists()){
            ImageIO.write(novImagem, "png", new File("./saida/", nomeArquivo));

        }else{
            saida.mkdir();
            ImageIO.write(novImagem, "png", new File("./saida/", nomeArquivo));

        }

        

    }

}
