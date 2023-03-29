import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import javax.imageio.ImageIO;


public class FabricaDeFigurinhas {
    public void cria(InputStream inputStream, String nomeArquivo, String ranking) throws Exception {
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

        //colocar a frase do sticker
        int textoLegenda = ranking.length();

        
        graphics.drawString(ranking, (largura/4) -textoLegenda, novaAltura-100);

          
        

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
