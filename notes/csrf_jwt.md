# CSRF vs. JWT: Differences and Examples

Cross-Site Request Forgery (CSRF) and JSON Web Tokens (JWT) are related to web security, but they serve different purposes and have distinct characteristics. Below, we'll explore the differences between CSRF and JWT, along with examples to illustrate each concept.

## CSRF (Cross-Site Request Forgery)

### Purpose:
CSRF is an attack that exploits the trust a website has in a user's browser. An attacker tricks the user's browser into performing actions on a different website without the user's knowledge or consent.

### Key Characteristics:
- CSRF attacks typically occur when a user is authenticated.
- Attackers forge a request that executes actions on a victim's behalf without their consent.
- CSRF attacks are based on exploiting the user's established session or authentication cookies.

### Example:
Suppose you are logged into your online banking account. An attacker sends you a seemingly harmless link that, when clicked, transfers funds from your account to the attacker's account without your knowledge or consent.

## JWT (JSON Web Token)

### Purpose:
JWT is a compact, self-contained means for securely transmitting information between parties. It is often used for authentication and authorization.

### Key Characteristics:
- JWT is a token format that contains claims (statements about an entity) to be used for authentication or authorization.
- It is typically generated on the server and signed with a secret key.
- JWTs are stateless, meaning the server does not need to store session data.

### Example:
In a web application, after successful authentication, the server generates a JWT containing the user's identity and permissions. This JWT is sent to the client, which includes it in subsequent requests. The server can validate the JWT's signature and extract the user's information to authorize requests.

## Differences:

1. **Purpose**:
   - CSRF is an attack that exploits a user's established session to perform unauthorized actions.
   - JWT is a token format for securely transmitting information for authentication and authorization.

2. **Authentication vs. Attack**:
   - CSRF is an attack vector, not an authentication mechanism.
   - JWT is a tool for implementing authentication and authorization.

3. **Token vs. Attack**:
   - CSRF is an attack where an attacker tricks a user's browser.
   - JWT is a token format for securely transmitting data.

4. **Authentication State**:
   - CSRF does not maintain authentication state but exploits it.
   - JWT is used to maintain and communicate authentication state.

In summary, CSRF is an attack that takes advantage of established user sessions, while JWT is a token format used for authentication and authorization. They serve different purposes and are not directly comparable. It's common to use JWT to protect against CSRF attacks by including anti-CSRF tokens within JWTs or using other mitigation techniques.
