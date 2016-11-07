<div class="concursos form">
<?php echo $this->Form->create('Concurso'); ?>
	<fieldset>
		<legend><?php echo __('Add Concurso'); ?></legend>
	<?php
		echo $this->Form->input('data_aprovacao');
		echo $this->Form->input('data_registo', array('type' => 'hidden'));
		echo $this->Form->input('nome');
	?>
	</fieldset>
<?php echo $this->Form->end(__('Submit')); ?>
</div>
<div class="actions">
	<h3><?php echo __('Actions'); ?></h3>
	<ul>

		<li><?php echo $this->Html->link(__('List Concursos'), array('action' => 'index')); ?></li>
	</ul>
</div>
