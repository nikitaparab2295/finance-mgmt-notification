package com.example.notification.web;

import com.example.notification.domain.Notification;
import com.example.notification.repository.NotificationRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {
    private final NotificationRepository repo;

    public NotificationController(NotificationRepository repo) { this.repo =
            repo; }

    @PostMapping
    public ResponseEntity<Notification> create(@Valid @RequestBody
                                               NotificationCreateRequest req){
        Notification n = Notification.builder()
                .ownerId(req.ownerId())
                .category(req.category())
                .level(req.level())
                .budgetAmount(req.budgetAmount())
                .expenseAmount(req.expenseAmount())
                .expenseDescription(req.expenseDescription())
                .totalSpent(req.totalSpent())
                .remaining(req.remaining())
                .readFlag(false)
                .createdAt(Instant.now())
                .build();
        Notification saved = repo.save(n);
        return ResponseEntity.created(URI.create("/api/notifications/" +
                saved.getId())).body(saved);
    }

    @GetMapping
    public ResponseEntity<List<Notification>> findByOwner(@RequestParam String
                                                                      ownerId){
        return ResponseEntity.ok(repo.findByOwnerId(ownerId));
    }

    public record NotificationCreateRequest(@NotBlank String ownerId, @NotBlank
                                            String category, @NotBlank String level,
                                            java.math.BigDecimal budgetAmount,
                                            java.math.BigDecimal expenseAmount,
                                            String expenseDescription,
                                            java.math.BigDecimal totalSpent, java.math.BigDecimal remaining){}
}