# <h1>Contexto<h1>

Este é um repositório destinado a armazenar o código do desafio proposto pela DIO, no BootCamp de Backend com Java, onde é requerida a criação de um diagrama UML referenciando as funções de um iPhone, neste caso o primeiro deles, lançado em 2007.

🔗 [Lançamento iPhone 2007](https://www.youtube.com/watch?v=9ou608QQRq8)

* Minutos relevantes [ 0:15 - 3:12 ]

\
Além do mais, no desafio, além da criação do diagrama UML, havia, de maneira opcional, o requerimento de implementação em código Java (Linguagem trabalhada no BootCamp).

A propósito, este é como seria o diagrama UML.

```mermaid
classDiagram
    
    class ReprodutorMusical {
        +exemploMetodo1()
        +exemploMetodo2(String exemplo)
    }

    class AparelhoTelefonico {
        +exemploMetodo1()
        +exemploMetodo2(String exemplo)
    }

    class NavegadorInternet {
        +exemploMetodo1()
        +exemploMetodo2(String exemplo)
    }

    class iPhone {
    }

    iPhone --> ReprodutorMusical
    iPhone --> AparelhoTelefonico
    iPhone --> NavegadorInternet
```
\
Durante a diagramação tornou-se notório a necessidade da adição de alguns outros métodos para o funcionamento do código.

Este abaixo, é o diagrama modificado a propósito da resolução do desafio.
```mermaid
classDiagram

    iPhone --> IOS
    IOS --> AppleMusic
    IOS --> Safari
    IOS --> Telefone

    class iPhone {
        -main(String[] args)
    }

    class IOS {
        +iniciarSistema() void
        -abrirApps() void
    }

    class AppleMusic {
        +iniciarAppleMusic() void
        -selecionarMusica() void
        -listaDeMusicas() void
        -tocarOUpausar() boolean
    }

    class Safari {
        +iniciarSafari() void
        -exibirPagina() void
        -adicionarNovaAba() void
        -atualizarPagina() void
    }

    class Telefone {
        +iniciarTelefone() void
        -ligar() void
        -atender() void
        -iniciarCorreioVoz() void
        -ligacaoRandom() boolean
        -discando() boolean
    }
```
