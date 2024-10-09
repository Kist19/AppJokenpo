package br.com.senacrs.usuario.appjokenpo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView txtEscolhaBot, txtEscolhaUsuario, txtResultado;
    ImageView imgInterrogacao;
    ImageButton imbtPedra, imbtPapel, imbtTesoura;
    Button btnReiniciar;
    int pontuacaoJogador = 0;
    int pontuacaoApp = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imbtPedra = findViewById(R.id.imbtPedra);
        imbtPapel = findViewById(R.id.imbtPapel);
        imbtTesoura = findViewById(R.id.imbtTesoura);
        btnReiniciar = findViewById(R.id.btnReiniciar);
        btnReiniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reiniciarJogo();
            }
        });
    }

    public void selecionadoPedra(View view) {
        this.opcaoSelecionado("pedra");
    }

    public void selecionadoPapel(View view) {
        this.opcaoSelecionado("papel");
    }

    public void SelecionadoTesoura(View view) {
        this.opcaoSelecionado("tesoura");
    }

    public void opcaoSelecionado(String opcaoSelecionada) {
        ImageView imageResultado = findViewById(R.id.imgInterrogacao);
        TextView txtResultado = findViewById(R.id.txtResultado);

        String opcoes[] = {"pedra", "papel", "tesoura"};
        String opcaoApp = opcoes[new Random().nextInt(3)];
        switch (opcaoApp) {
            case "pedra":
                imageResultado.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                imageResultado.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                imageResultado.setImageResource(R.drawable.tesoura);
                break;
        }
        if ((opcaoApp.equals("tesoura") && opcaoSelecionada.equals("papel")) ||
                (opcaoApp.equals("papel") && opcaoSelecionada.equals("pedra")) ||
                (opcaoApp.equals("pedra") && opcaoSelecionada.equals("tesoura"))) {
            txtResultado.setText("Resultado: Você PERDEU... :(");
            pontuacaoApp++;
        } else if ((opcaoSelecionada.equals("tesoura") && opcaoApp.equals("papel")) ||
                (opcaoSelecionada.equals("papel") && opcaoApp.equals("pedra")) ||
                (opcaoSelecionada.equals("pedra") && opcaoApp.equals("tesoura"))) {
            txtResultado.setText("Resultado: Você GANHOU... ;D");
            pontuacaoJogador++;
        } else {
            txtResultado.setText("Resultado: Vocês EMPATARAM... :|");
        }
        atualizarplacar();
    }

    public void atualizarplacar() {
        TextView txtPlacar = findViewById(R.id.txtPlacar);
        txtPlacar.setText("Jogador: " + pontuacaoJogador + " App: " + pontuacaoApp);
    }

    public void reiniciarJogo() {
        pontuacaoJogador = 0;
        pontuacaoApp = 0;
    }
}