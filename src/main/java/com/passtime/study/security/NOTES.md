# Fluxo do Spring Security

## Fluxo de Autenticação

AuthenticationFilter

│  cria Authentication (unauthenticated)
▼

AuthenticationManager (ProviderManager)

│  delega para um ou mais:
▼

AuthenticationProvider (ex: DaoAuthenticationProvider)

│  chama:
▼

UserDetailsService.loadUserByUsername()

│  retorna UserDetails
▼

Authentication (authenticated) → armazena em:

▼
SecurityContextHolder (ThreadLocal por padrão)

## Fluxo e Autorização
Authentication (do SecurityContextHolder)
│  contém GrantedAuthority[] (roles/permissions)
▼
AuthorizationFilter

│  verifica regras definidas em:

├── HttpSecurity.authorizeHttpRequests()  (por URL)

└── @PreAuthorize / @PostAuthorize         (por método)


# Conceitos de autenticação

PROTOCOLO/FRAMEWORK        FORMATO DE TOKEN       TIPO DE TOKEN
──────────────────         ────────────────       ─────────────
OAuth 2.0 (autorização)    JWT (estrutura)        Bearer (posse)
OIDC (autenticação)        Opaque (referência)
OAuth 1.0 (antigo)

- JWT é um formato de token — estruturado, auto-contido, verificável sem banco
- Bearer é um tipo de token — "quem tem, usa". Um JWT é frequentemente um Bearer token, mas Bearer token não precisa ser JWT
- OAuth 2.0 é um framework de autorização, não de autenticação. Ele define como tokens são emitidos e usados
- OpenID Connect (OIDC) é uma camada de autenticação em cima do OAuth 2.0

  ---
Como o Spring Security organiza isso

Existem três papéis que sua aplicação pode assumir:

1. Resource Server   → recebe tokens, valida, serve recursos
2. OAuth2 Client     → redireciona usuário para login externo (Google, GitHub)
3. Authorization Server → EMITE tokens (projeto separado: Spring Authorization Server)

Na maioria dos projetos de API, você implementa o Resource Server. O OAuth2 Client é para quando você quer "Login com Google". O Authorization Server é raramente você quem escreve.

  ---
O ponto de extensão que unifica tudo

Independente do mecanismo, o fluxo do mapa mental anterior se mantém:

Mecanismo específico             sempre produz
────────────────────────────     ─────────────────────────────────────
UsernamePasswordAuthFilter  →    UsernamePasswordAuthenticationToken
BearerTokenAuthFilter       →    BearerTokenAuthenticationToken
OAuth2LoginAuthFilter       →    OAuth2AuthenticationToken
│
▼
SecurityContextHolder

O Spring Security é extensível aqui: se nenhum mecanismo padrão atende, você implementa seu próprio AbstractAuthenticationProcessingFilter + AuthenticationProvider.