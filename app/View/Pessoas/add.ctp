<h3>Formulario de registo de pessoas</h3>

<?php echo $this->Form->create('Pessoa'); ?>
<div>
    <div class="form-group">
		<?php echo $this->Form->input('nome', array('class'=>'form-control'));?>
    </div>
</div>
<div class="form-group">
	<?php echo $this->Form->input('apelido', array('class' => 'form-control'));?>
</div>
<div>
    <div class="form-group">
        <?php echo $this->Form->input('data', array('class' => 'form-control'));?>
    </div>
</div>

<!-- Raised button -->
<!-- Accent-colored raised button with ripple -->
<button class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent">
    Guardar dados
</button>

<?php echo $this->Form->end(); ?>

<div class="actions">
    <h3><?php echo __('Actions'); ?></h3>
    <ul>
        <li><?php echo $this->Html->link(__('List Pessoas'), array('action' => 'index')); ?></li>
    </ul>
</div>

