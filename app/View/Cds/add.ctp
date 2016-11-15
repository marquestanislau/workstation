<div class="mdl-cell mdl-cell--2-col"></div>
<div class="cds form">
<?php echo $this->Form->create('Cd'); ?>
	<fieldset>
		<legend><?php echo __('Add Cd'); ?></legend>
	<?php
		echo $this->Form->input('cadeira');
                echo $this->Form->input('Funcionario.nome');
                echo $this->Form->input('Funcionario.apelido');
		echo $this->Form->input('funcionario_id', array('type' => 'hidden'));
	?>
	</fieldset>
<?php echo $this->Form->end(__('Submit')); ?>
</div>
<div class="actions">
	<h3><?php echo __('Actions'); ?></h3>
	<ul>

		<li><?php echo $this->Html->link(__('List Cds'), array('action' => 'index')); ?></li>
		<li><?php echo $this->Html->link(__('List Funcionarios'), array('controller' => 'funcionarios', 'action' => 'index')); ?> </li>
		<li><?php echo $this->Html->link(__('New Funcionario'), array('controller' => 'funcionarios', 'action' => 'add')); ?> </li>
	</ul>
</div>
