package controllers;
import exceptions.AccountNotFoundException;
import exceptions.ReservacionNoCuposDisponiblesException;
import models.account;
import models.reservacion;
import repositories.accountRepository;
import repositories.reservacionRepository;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReservacionController {
    private final accountRepository accountRepository;
    private final reservacionRepository transactionRepository;
    public ReservacionController(accountRepository accountRepository,
                                 reservacionRepository transactionRepository) {
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }
    @PostMapping("/reservas")
    reservacion newreservacion(@RequestBody reservacion reserva){
        account accountOrigin =
                accountRepository.findById(reserva.getUsernameUbOrigin()).orElse(null);
        account accountDestinity=
                accountRepository.findById(reserva.getUsernameUbHotel()).orElse(null);
        if (accountOrigin == null)
            throw new AccountNotFoundException("No se encontro una cuenta con el username: " + reserva.getUsernameUbOrigin());
        if (accountDestinity == null)
            throw new AccountNotFoundException("No se encontro una cuenta con el username: " + reserva.getUsernameUbHotel());
        if(accountOrigin.getReservacion() < reserva.getValue())
            throw new ReservacionNoCuposDisponiblesException("No hay habitaciones disponibles");
        accountOrigin.setReservacion(accountOrigin.getReservacion() - reserva.getValue());
        accountOrigin.setLastChange(new Date());
        accountRepository.save(accountOrigin);
        accountDestinity.setReservacion(accountDestinity.getReservacion() +
                reserva.getValue());
        accountDestinity.setLastChange(new Date());
        accountRepository.save(accountDestinity);
        reserva.setDate(new Date());
        return transactionRepository.save(reserva);
    }
    @GetMapping("/reservacion/{username}")
    List<reservacion> userTransaction(@PathVariable String username){
        account userAccount = accountRepository.findById(username).orElse(null);
        if (userAccount == null)
            throw new AccountNotFoundException("No se encontro una cuenta con el username: " + username);
                    List<reservacion> reservacionOrigin = transactionRepository.findByUsernameUbOrigin (username);
        List<reservacion> transactionsDestinity = transactionRepository.findByUsernameUbHotel(username);
        List<reservacion> reservaciones = Stream.concat(reservacionOrigin.stream(), transactionsDestinity.stream()).collect(Collectors.toList());
        return reservaciones;
    }

    }
