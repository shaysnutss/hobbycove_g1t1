// package Test.demo.Explore;

// @Component
// @Order(1)
// public class TransactionFilter implements Filter {

//     @Override
//     public void doFilter(
//       ServletRequest request, 
//       ServletResponse response, 
//       FilterChain chain) throws IOException, ServletException {
 
//         HttpServletRequest req = (HttpServletRequest) request;
//         LOG.info(
//           "Starting a transaction for req : {}", 
//           req.getRequestURI());
 
//         chain.doFilter(request, response);
//         LOG.info(
//           "Committing a transaction for req : {}", 
//           req.getRequestURI());
//     }

//     @Component
// @Order(2)
// public class RequestResponseLoggingFilter implements Filter {

//     @Override
//     public void doFilter(
//       ServletRequest request, 
//       ServletResponse response, 
//       FilterChain chain) throws IOException, ServletException {
 
//         HttpServletRequest req = (HttpServletRequest) request;
//         HttpServletResponse res = (HttpServletResponse) response;
//         LOG.info(
//           "Logging Request  {} : {}", req.getMethod(), 
//           req.getRequestURI());
//         chain.doFilter(request, response);
//         LOG.info(
//           "Logging Response :{}", 
//           res.getContentType());
//     }

//     // other methods
// }

// }

