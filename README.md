# 🃏 Jogo da Memória com LibGDX

Este é um jogo da memória desenvolvido em Java com a biblioteca **LibGDX**. O projeto implementa uma sequência de níveis (Fácil → Médio → Difícil → Aleatório) e utiliza padrões de projeto como **Abstract Factory** e **Decorator** para tornar o código mais modular, reutilizável e extensível.

---

## 🧠 Funcionalidades

- Modo de jogo com níveis progressivos: **Fácil**, **Médio**, **Difícil** e **Aleatório**
- Sistema de **cronômetro** por nível
- Cartas animadas e com efeitos sonoros ao serem clicadas
- Comparação de cartas com lógica de pares
- Tela de **vitória** ou **derrota** ao final de cada fase
- Menu inicial com botões de **Jogar** e **Sair**

---

## 🧱 Estrutura do Projeto

### 🎮 `Carta`
Classe principal que representa uma carta no jogo. Herda de `Actor` e exibe a frente ou verso com base no estado (`virada`). Possui listener para manipular interações do usuário.

### 🧪 `JogoScreen`
Controla o estado da fase do jogo: renderização, comparação de cartas, gerenciamento de tempo e transição entre níveis.

### 🏠 `MenuScreen`
Tela inicial com botões para iniciar o jogo ou sair da aplicação.

### 🏗️ `NivelFactory` (Abstract Factory)
Define uma interface para criação de cartas e cronômetro de acordo com a dificuldade.

### ✨ `CartaDecorator` (Decorator)
Interface para aplicar **efeitos visuais e sonoros** nas cartas ao serem clicadas:
- `CartaSom`: reproduz som ao clicar.
- `CartaAnimacao`: adiciona animação de rotação ao clicar.

---

## 🔧 Como Executar

1. **Pré-requisitos**
   - Java JDK 8 ou superior
   - Gradle (ou utilizar `gradlew`/`gradlew.bat` do LibGDX)
   - LibGDX configurado corretamente

2. **Clone o repositório**
   ```bash
   git clone https://github.com/seu-usuario/jogo-da-memoria-libgdx.git
   ```

3. **Execute com Gradle**
   ```bash
   ./gradlew desktop:run
   ```

   Ou no Windows:

   ```cmd
   gradlew.bat desktop:run
   ```

4. **(Opcional) Exportar como `.jar`**
   Para exportar o jogo como um arquivo executável `.jar`, use:
   ```bash
   ./gradlew desktop:dist
   ```

   O arquivo será gerado em:  
   `desktop/build/libs/`

---

## 🧠 Padrões de Projeto Utilizados

- **Abstract Factory:**  
  Usado para encapsular a criação de cartas e cronômetro em cada nível (`FacilFactory`, `MedioFactory`, etc).

- **Decorator:**  
  Adiciona funcionalidades como som e animação à carta clicada, sem modificar a classe original.

---

## 📁 Assets

- Imagens das cartas: `assets/cartaX.png`
- Verso das cartas: `assets/verso.png`
- Fonte: `assets/ARIALBD.TTF`
- Skin UI: `assets/uiskin.json`
- Título do jogo: `assets/titulo.png`
- Sons: `assets/som.mp3`, etc.

> Certifique-se de que todos os arquivos estão corretamente posicionados dentro da pasta `assets/`.

---

## 📸 Screenshots

*(Adicione imagens aqui, como o menu, cartas viradas, animações, etc.)*

---

## 📃 Licença

Este projeto é livre para fins educacionais. Personalize como desejar!

---

## 👨‍💻 Autores

- **Leoman Cássio**  
- **Cauane Galdino**

---